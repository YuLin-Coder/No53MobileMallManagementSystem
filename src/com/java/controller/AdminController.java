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
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.model.*;
import com.java.service.*;
import com.java.utils.CommonUtils;
import com.java.utils.PageList;
import com.java.utils.ResponseUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	

	@SuppressWarnings("finally")
	@RequestMapping("/addpage")
	public String add(Model m) {
		return "admin/addadmin";
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("/pwdpage")
	public String pwdpage(Model m) {
		return "admin/pwd";
	}
	
	@RequestMapping("/editpage")
	public String Edit(Model m) {
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			Admin r = adminService.GetByID(id);
			m.addAttribute("admin",r);
			return "admin/addadmin";
		} catch (Exception e) {
			return null;
		}
	}
	
	
	

	
	@SuppressWarnings("finally")
	@RequestMapping("/add")
	public String add(Admin s) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			System.out.println(s);
			int count=0;
			if(s.getId()==null)
				count = adminService.Add(s);
			else
				count=adminService.Edit(s);
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
			List<Admin> list = adminService.Get();
			System.out.println(list);
			request.setAttribute("list", list);
			return "admin/admin";
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	@SuppressWarnings("finally")
	@RequestMapping("/del")
	public String Del(int id) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			System.out.println("================================");
			System.out.println(id);
			//int id=Integer.parseInt(request.getParameter("id"));
			
			int r = adminService.Del(id);
			
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
	
	
	@RequestMapping("/login")
	public String Login(Admin admin) {
		try {
			Admin a = adminService.Login(admin.getLogin());
			System.out.println(admin);
			if(a==null)
				return Util.SetMap("没有该用户", false, response);
			else if(!a.getPwd().equals(admin.getPwd()))
				return Util.SetMap("密码错误", false, response);
			else
			{
				request.getSession().setAttribute("admin", a);
				return Util.SetMap("验证通过", true, response);
			}
		} catch (Exception e) {
			return Util.SetMap(e.getMessage(), false, response);
		} 
	}
	
	
	@SuppressWarnings("finally")
	@RequestMapping("/pwd")
	public String EditPass() {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			Admin admin=(Admin)request.getSession().getAttribute("admin");
			admin.setPwd(request.getParameter("pwd"));
			int r=adminService.EditPass(admin);
			if(r>0)
			{
				map.put("mgf", "密码修改成功，下次请用新密码登陆");
				map.put("success", true);
				request.getSession().setAttribute("admin", admin);
			}
			else
			{
				map.put("mgf", "密码修改失败");
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

	
	@RequestMapping("/exit")
	public String Exit() {
		
		request.getSession().removeAttribute("admin");
			
		return Util.SetMap("成功退出", true, response);
	}
}