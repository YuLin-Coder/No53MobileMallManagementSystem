package com.java.dao;

import java.util.List;

import com.java.model.Admin;

public interface AdminMapper {
    Admin Login(String login);
    int Del(int id);
    int Add(Admin a);
    int Edit(Admin a);
    int EditPass(Admin a);
    List<Admin> Get();
    Admin GetByID(int a);
}