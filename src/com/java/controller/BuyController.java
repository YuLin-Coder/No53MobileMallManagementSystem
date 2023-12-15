package com.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.*;
import com.java.service.*;
import com.java.utils.CommonUtils;
import com.java.utils.PageList;
import com.java.utils.ResponseUtil;;

@Controller
@RequestMapping("/buy")
public class BuyController {
	private BuyService buyService;

	public BuyService getBuyService() {
		return buyService;
	}
	@Autowired
	private ThingTypeService thingtypeService;
	@Autowired
	private BuyListService buylistService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private ThingType2Service thingtype2Service;
	@Autowired
	public void setBuyService(BuyService buyService) {
		this.buyService = buyService;
	}
	@Autowired
	private ThingService thingService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/buying")
	public String buying(Thing t) {
		if(request.getSession().getAttribute("client")==null)
			return Util.SetMap("您尚未登陆", false, response);
		List<BuyList> l=null;
		if(request.getSession().getAttribute("buying")==null)
			l=new ArrayList<BuyList>();
		else
		{
			l=(List<BuyList>)request.getSession().getAttribute("buying");
			for(int i=0;i<l.size();i++)
				if(l.get(i).getThingId()==t.getId())
					return Util.SetMap("该商品已存在购物车", false, response);
		}
		Thing thing=thingService.GetByID(t.getId());
		if(thing.getNum()<1)
			return Util.SetMap("库存不足", false, response);
		BuyList b=new BuyList();
		b.setThing(thing);
		b.setThingId(thing.getId());
		b.setNumMax(thing.getNum());
		l.add(b);
		
		request.getSession().setAttribute("buying", l);
		return Util.SetMap("成功加入购物车", true, response);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getbuying")
	public String getbuying(Model m) {
		List<BuyList> l=null;
		if(request.getSession().getAttribute("buying")==null)
			l=new ArrayList<BuyList>();
		else
			l=(List<BuyList>)request.getSession().getAttribute("buying");
		int sum=0;
		for(int i=0;i<l.size();i++)
			sum+=l.get(i).getThing().getPrice();
		m.addAttribute("buying",l);
		m.addAttribute("sum",sum);
		return "buying";
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("/delbuying")
	public String delbuying(int tid) {
		List<BuyList> l=(List<BuyList>)request.getSession().getAttribute("buying");
		int sum=0;
		for(int i=0;i<l.size();i++)
			if(l.get(i).getThingId()==tid)
				l.remove(i);
			else
				sum+=l.get(i).getThing().getPrice();
		request.getSession().setAttribute("buying", l);
		request.setAttribute("buying",l);
		request.setAttribute("sum",sum);
		return Util.SetMap("取消成功", true, response);
	}


	@SuppressWarnings("finally")
	@RequestMapping("/state")
	public String state(Buy b) {
		int count=buyService.EditState(b);
		if(count>0)
			return Util.SetMap("操作成功", true, response);
		else
			return Util.SetMap("操作失败", false, response);
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("/add")
	public String add(String allStr) {
		System.out.println("allStr="+allStr);


		String[] buyListId=allStr.split(",");
		List<Map<String,String>> maps=new ArrayList<>();
		for(int i=0;i<buyListId.length;i++){
			String [] ids=buyListId[i].split("_");
			Map map=new HashMap();
			map.put(ids[0],ids[1]);
			maps.add(map);
		}

		System.out.println(maps.toString());

		if(request.getSession().getAttribute("buying")==null)
			return Util.SetMap("您的购物车中无任何商品", false, response);
		Buy bl=new Buy();
		bl.setState(0);
		List<BuyList> l=(List<BuyList>)request.getSession().getAttribute("buying");

		Client c=(Client)request.getSession().getAttribute("client");
		Buy b=new Buy();
		b.setClientId(c.getId());
		int id = buyService.Add(b);
		id=b.getId();
		if(id<1)
			return Util.SetMap("提交失败", false, response);
		try {
			int count=0;
			List<BuyList> l2=new ArrayList<>();
			for(int i=0;i<l.size();i++)
			{
				l.get(i).setBuyId(id);
				boolean b22=false;
				for(Map<String ,String> map1:maps){
					String thingNum=map1.get(String.valueOf(l.get(i).getThingId()));
					if(thingNum!=null){

						BuyList buyList1=l.get(i);
						b22=true;
						buyList1.setNum(Integer.valueOf(thingNum));
						count+=buylistService.Add(l.get(i));
						Thing edit_thing=l.get(i).getThing();
						edit_thing.setNum(edit_thing.getNum()-Integer.valueOf(thingNum));
						thingService.EditNum(edit_thing);
					}
				}
				if(!b22){
					l2.add(l.get(i));
				}
			}
			if(count>0)
			{

				request.getSession().removeAttribute("buying");
				request.getSession().setAttribute("buying",l2);
				return Util.SetMap("下单成功", true, response);
			}
			else
				return Util.SetMap("提交失败", false, response);
		} catch (Exception e) {
			return Util.SetMap(e.getMessage(), false, response);
		} 
	}
	
	@RequestMapping("/my_list")
	public String Get(Buy b) {
		b.setState(-1);
		Client c=(Client)request.getSession().getAttribute("client");
		//分页参数设置
		Pages p=new Pages();
		p.setPagesize(6);//每页显示数量 
		p.setOrder("id desc");
		int startindex=request.getParameter("startindex")==null?0:Integer.parseInt(request.getParameter("startindex"));//起始页，默认从第1页开始读
		p.setStartindex(startindex);
		b.setPage(p);
		b.setClientId(c.getId());
		try {
			List<Buy> list = buyService.Get(b);
			System.out.println(list);
			request.setAttribute("list", list);
			//分页
			request.setAttribute("pages", PageList.Page(request,"buy/my_list.do", buyService.GetCount(b), 
					p.getPagesize(), p.getStartindex(),request.getQueryString()));
			return "user/mybuy";
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@RequestMapping("/admin_list")
	public String admin_list(Buy b) {
		//分页参数设置
		Pages p=new Pages();
		p.setPagesize(6);//每页显示数量 
		int startindex=request.getParameter("startindex")==null?0:Integer.parseInt(request.getParameter("startindex"));//起始页，默认从第1页开始读
		p.setStartindex(startindex);
		b.setPage(p);
		try {
			List<Buy> list = buyService.Get(b);
			for(int i=0;i<list.size();i++)
			{
				Client c=clientService.GetByID(list.get(i).getClientId());
				list.get(i).setClient(c);
			}
			System.out.println(list);
			request.setAttribute("list", list);
			//分页
			request.setAttribute("pages", PageList.Page(request,"buy/admin_list.do", buyService.GetCount(b), 
					p.getPagesize(), p.getStartindex(),request.getQueryString()));
			return "admin/buy";
		} catch (Exception e) {
			return null;
		}
		
	}

	
	@SuppressWarnings("finally")
	@RequestMapping("/del")
	public String Del(int id) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		Buy b=buyService.GetByID(id);
		if(b.getState()>0)
		{
			map.put("mgf", "该商品已发货或已成交，拒绝退单");
			map.put("success", false);
			String result = new JSONObject(map).toString();
			ResponseUtil.write(response, result);
			return null;
		}
		try {
			System.out.println("================================");
			System.out.println(id);
			//int id=Integer.parseInt(request.getParameter("id"));
			
			int r = buyService.Del(id);
			
			if(r>0)
			{
				map.put("mgf", "您已成功发起退款申请，请耐心等待商家处理");
				map.put("success", true);
			}
			else
			{
				map.put("mgf", "退单失败");
				map.put("success", false);
			}
		} catch (Exception e) {
			map.put("mgf", "错误："+e.getMessage());
			map.put("success", false);
		} 
		String result = new JSONObject(map).toString();
		ResponseUtil.write(response, result);
		return null;
	}
	
	
}