package com.java.service;



import java.util.List;

import com.java.model.*;

public interface BuyListService {

	public int Add(BuyList r);
	public BuyList GetByID(int id);
	public int Del(int id);
	public List<BuyList> Get(BuyList s);
	public int GetCount(BuyList s);
}
