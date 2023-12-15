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
import com.java.utils.PageList;
import com.java.utils.ResponseUtil;;

@Controller
@RequestMapping("/thingtype2")
public class ThingType2Controller {
	private ThingType2Service thingtype2Service;

	public ThingType2Service getThingType2Service() {
		return thingtype2Service;
	}

	@Autowired
	public void setThingType2Service(ThingType2Service thingtype2Service) {
		this.thingtype2Service = thingtype2Service;
	}

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	@SuppressWarnings("finally")
	@RequestMapping("/addpage")
	public String add() {
		return "admin/addthingtype2";
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("/add")
	public String add(ThingType2 q) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			System.out.println(q);
			String id=request.getParameter("id").trim().length()==0?"0":request.getParameter("id");
			q.setId(Integer.parseInt(id));
			int count=0;
			if(q.getId()==0)
				count = thingtype2Service.Add(q);
			else
				count=thingtype2Service.Edit(q);
			if(count>0)
			{
				map.put("mgf", "操作成功");
				map.put("success", true);
			}
			else
			{
				map.put("mgf", "操作失败");
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

	@RequestMapping("/admin_list")
	public String Get() {
		try {
			List<ThingType2> list = thingtype2Service.Get();
			System.out.println(list);
			request.setAttribute("list", list);
			return "admin/thingtype2";
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@RequestMapping("/web_list")
	public String Get2() {
		try {
			List<ThingType2> list = thingtype2Service.Get();
			System.out.println(list);
			request.setAttribute("list", list);
			return "thingtype2";
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@RequestMapping("/editpage")
	public String GetByID() {
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			ThingType2 q = thingtype2Service.GetByID(id);
			request.setAttribute("add", q);
			return "admin/addthingtype2";
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping("del")
	public String Del(@RequestParam(value = "id") int id) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			System.out.println("================================");
			System.out.println(id);
			//int id=Integer.parseInt(request.getParameter("id"));
			
			int r = thingtype2Service.Del(id);
			
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