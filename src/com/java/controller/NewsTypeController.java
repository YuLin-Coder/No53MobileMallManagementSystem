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
import org.springframework.ui.Model;
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
@RequestMapping("/newstype")
public class NewsTypeController {
	private NewsTypeService newstypeService;

	public NewsTypeService getNewsTypeService() {
		return newstypeService;
	}

	@Autowired
	public void setNewsTypeService(NewsTypeService newstypeService) {
		this.newstypeService = newstypeService;
	}
	@Autowired
	private ClientService clientService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	@SuppressWarnings("finally")
	@RequestMapping("/addpage")
	public String add() {
		System.out.println(request.getParameter("id"));
		int id=0;
		if(request.getParameter("id")!=null)
			id=Integer.parseInt(request.getParameter("id"));
		NewsType h = newstypeService.GetByID(id);
		request.setAttribute("newstype", h);
		return "admin/addnewstype";
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(NewsType nt) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			System.out.println(nt);
			String id=request.getParameter("id").trim().length()==0?"0":request.getParameter("id");
			nt.setId(Integer.parseInt(id));
			int r=0;
			if(nt.getId()==0)
				r = newstypeService.Add(nt);
			else
				r=newstypeService.Edit(nt);
			if(r>0)
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

	@RequestMapping("/newstype_list")
	public String Get() {
		try {
			List<NewsType> list = newstypeService.Get();
			System.out.println(list);
			request.setAttribute("list", list);
			return "admin/newstype";
		} catch (Exception e) {
			return null;
		}
		
	}
	
/*	@RequestMapping("/menu")
	public String Left() {
		try {
			List<NewsType> list = newstypeService.Get();
			request.getSession().setAttribute("menu", list);
			request.setAttribute("leftandtop", list);
			return null;
		} catch (Exception e) {
			return null;
		}
		
	}*/
	
	
	@RequestMapping("/web_list")
	public String Get2() {
		try {
			List<NewsType> list = newstypeService.Get();
			System.out.println(list);
			request.setAttribute("list", list);
			return "newstype";
		} catch (Exception e) {
			return null;
		}
		
	}

	
	@SuppressWarnings("finally")
	@RequestMapping(value="/newstype_del", method = RequestMethod.POST)
	public String Del(@RequestParam(value = "id") int id) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			System.out.println("================================");
			System.out.println(id);
			int r = newstypeService.Del(id);
			
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