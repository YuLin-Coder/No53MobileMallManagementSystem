package com.java.service;



import java.util.List;
import java.util.Map;

import com.java.model.*;

public interface ClientService {

	public int Add(Client client);
	public int Edit(Client client);
	public int EditPass(Client client);
	public List<Map> GetMy(Client c);
	public Client GetByID(int id);
	public int Del(int id);
	public List<Client> Get(Client c);
	public int GetCount(Client c);
	public Client Login(String login);
}
