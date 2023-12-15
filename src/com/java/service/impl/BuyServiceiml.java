package com.java.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.*;
import com.java.model.*;
import com.java.service.BuyService;
@Service("BuyService")
public class BuyServiceiml implements BuyService {

	private BuyMapper buyMapper;

	public BuyMapper getAddMapper() {
		return buyMapper;
	}
	@Autowired
	public void setAddMapper(BuyMapper buyMapper) {
		this.buyMapper = buyMapper;
	}
	
	
	@Override    
	public int EditState(Buy buy) {
		return buyMapper.EditState(buy);
	}
	
	@Override
	public Buy GetByID(int id) {
		return buyMapper.GetByID(id);
	}
	
	@Override
	public int Add(Buy buy) {
		return buyMapper.Add(buy);
	}
	
	@Override
	public int Del(int id) {
		int result = buyMapper.Del(id);
		return result;
	}

	@Override
	public List<Buy> Get(Buy buy) {
		return buyMapper.Get(buy);
	}
	
	@Override
	public int GetCount(Buy buy) {
		return buyMapper.GetCount(buy);
	}

}
