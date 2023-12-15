package com.java.service;



import java.util.List;

import com.java.model.*;

public interface AdminService {

	public Admin Login(String login);
	public int Add(Admin r);
	public int Edit(Admin r);
	public int EditPass(Admin r);
	public Admin GetByID(int id);
	public int Del(int id);
	public List<Admin> Get();
}
