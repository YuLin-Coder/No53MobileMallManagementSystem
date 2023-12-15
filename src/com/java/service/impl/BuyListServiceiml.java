package com.java.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.*;
import com.java.model.*;
import com.java.service.BuyListService;
@Service("BuyListService")
public class BuyListServiceiml implements BuyListService {

	private BuyListMapper buylistMapper;

	public BuyListMapper getAddMapper() {
		return buylistMapper;
	}
	@Autowired
	public void setAddMapper(BuyListMapper buylistMapper) {
		this.buylistMapper = buylistMapper;
	}
	
	
	@Override
	public BuyList GetByID(int id) {
		return buylistMapper.GetByID(id);
	}
	
	@Override
	public int Add(BuyList buylist) {
		return buylistMapper.Add(buylist);
	}
	
	
	@Override
	public int Del(int id) {
		int result = buylistMapper.Del(id);
		return result;
	}

	@Override
	public List<BuyList> Get(BuyList buylist) {
		return buylistMapper.Get(buylist);
	}
	
	@Override
	public int GetCount(BuyList buylist) {
		return buylistMapper.GetCount(buylist);
	}
}
