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
@RequestMapping("/buylist")
public class BuyListController {
	@Autowired
	private BuyService buyService;
	@Autowired
	private BuyListService buylistService;
	@Autowired
	private ThingService thingservice;

	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping("/my_list")
	public String Get(BuyList bl) {
		try {
			List<BuyList> list = buylistService.Get(bl);
			for(int i=0;i<list.size();i++)
			{
				Thing t=thingservice.GetByID(list.get(i).getThingId());
				list.get(i).setThing(t);
			}
			System.out.println(list);
			request.setAttribute("list", list);
			return "user/mybuylist";
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@RequestMapping("/admin_list")
	public String admin_list(BuyList bl) {
		try {
			List<BuyList> list = buylistService.Get(bl);
			for(int i=0;i<list.size();i++)
			{
				Thing t=thingservice.GetByID(list.get(i).getThingId());
				list.get(i).setThing(t);
			}
			System.out.println(list);
			request.setAttribute("list", list);
			return "admin/buylist";
		} catch (Exception e) {
			return null;
		}
		
	}
	

	
	@SuppressWarnings("finally")
	@RequestMapping("/del")
	public String Del(int id) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		BuyList b=buylistService.GetByID(id);
		Buy buy=buyService.GetByID(b.getBuyId());
		if(buy.getState()>0)
		{
			map.put("mgf", "该次交易已发货或已被签收，拒绝退单");
			map.put("success", false);
			String result = new JSONObject(map).toString();
			ResponseUtil.write(response, result);
			return null;
		}
		try {
			System.out.println("================================");
			System.out.println(id);
			//int id=Integer.parseInt(request.getParameter("id"));
			BuyList buyList= buylistService.GetByID(id);
			Thing thing=thingservice.GetByID(buyList.getThingId());
			thing.setNum(thing.getNum()+buyList.getNum());
			thingservice.EditNum(thing) ;
			int r = buylistService.Del(id);

			List<BuyList> list = buylistService.Get(buyList);
			if(list==null || list.size()==0){
				buyService.Del(buyList.getBuyId());
			}

			if(r>0)
			{
				map.put("mgf", "退单成功");
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