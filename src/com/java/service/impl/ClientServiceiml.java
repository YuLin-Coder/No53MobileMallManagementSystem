package com.java.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.*;
import com.java.model.*;
import com.java.service.ClientService;
@Service("ClientService")
public class ClientServiceiml implements ClientService {

	private ClientMapper clientMapper;

	public ClientMapper getAddMapper() {
		return clientMapper;
	}
	@Autowired
	public void setAddMapper(ClientMapper clientMapper) {
		this.clientMapper = clientMapper;
	}
	
	@Override    
	public int Edit(Client client) {
		return clientMapper.Edit(client);
	}
	
	@Override
	public Client GetByID(int id) {
		return clientMapper.GetByID(id);
	}
	
	@Override
	public Client Login(String login) {
		return clientMapper.Login(login);
	}
	
	@Override
	public int Add(Client client) {
		return clientMapper.Add(client);
	}
	
	@Override
	public int Del(int id) {
		int result = clientMapper.Del(id);
		System.out.println("no:"+result);
		return result;
	}

	@Override
	public List<Client> Get(Client c) {
		return clientMapper.Get(c);
	}

	@Override
	public List<Map> GetMy(Client c) {
		return clientMapper.GetMy(c);
	}
	@Override
	public int EditPass(Client client) {
		// TODO Auto-generated method stub
		return clientMapper.EditPass(client);
	}
	@Override
	public int GetCount(Client c) {
		// TODO Auto-generated method stub
		return clientMapper.GetCount(c);
	}

}
