package com.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.*;
import com.java.service.*;
import com.java.utils.CommonUtils;
import com.java.utils.ResponseUtil;;

@Controller
@RequestMapping("/pinglun")
public class PingLunController {
	private PingLunService pinglunService;

	public PingLunService getPingLunService() {
		return pinglunService;
	}

	@Autowired
	public void setPingLunService(PingLunService pinglunService) {
		this.pinglunService = pinglunService;
	}

	@Autowired
	private ThingService thingService;
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	
	@SuppressWarnings("finally")
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(PingLun jp) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if(request.getSession().getAttribute("client")==null)
			{
				map.put("mgf", "您尚未登陆");
				map.put("success", false);
				String result = new JSONObject(map).toString();
				ResponseUtil.write(response, result);
				return null;
			}
			System.out.println(jp.getContent());
			Client c=(Client)request.getSession().getAttribute("client");
			jp.setClinetId(c.getId());
			jp.setContent(request.getParameter("content"));
			jp.setThingId(Integer.parseInt(request.getParameter("id")));
			int count = pinglunService.Add(jp);
			if(count>0)
			{
				map.put("mgf", "点评成功");
				map.put("success", true);
			}
			else
			{
				map.put("mgf", "点评失败");
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

	@RequestMapping("/my_list")
	public String GetByClientID() {
		try {
			Client c=(Client)request.getSession().getAttribute("client");
			List<PingLun> list = pinglunService.GetByClientID(c.getId());
			for(int i=0;i<list.size();i++)
			{
				Thing j=thingService.GetByID(list.get(i).getThingId());
				list.get(i).setThing(j);;
			}
			System.out.println(list);
			request.setAttribute("list", list);
			return "user/mypinglun";
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@RequestMapping("/admin_list")
	public String GetByNewsID(int jid) {
		try {
			List<PingLun> list = pinglunService.GetByThingID(jid);
			for(int i=0;i<list.size();i++)
			{
				Thing n=thingService.GetByID(list.get(i).getThingId());
				list.get(i).setThing(n);;
			}
			System.out.println(list);
			request.setAttribute("list", list);
			return "admin/pinglun";
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/del", method = RequestMethod.POST)
	public String Del(@RequestParam(value = "id") int id) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			System.out.println("================================");
			System.out.println(id);
			//int id=Integer.parseInt(request.getParameter("id"));
			
			int r = pinglunService.Del(id);
			
			if(r>0)
			{
				map.put("mgf", "删除成功");
				map.put("success", true);
			}
			else
			{
				map.put("mgf", "删除失败");
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