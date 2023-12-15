package com.java.service;



import java.util.List;

import com.java.model.*;

public interface BuyService {

	public int Add(Buy r);
	public Buy GetByID(int id);
	public int Del(int id);
	public List<Buy> Get(Buy s);
	public int GetCount(Buy s);
	public int EditState(Buy s);
	
}
