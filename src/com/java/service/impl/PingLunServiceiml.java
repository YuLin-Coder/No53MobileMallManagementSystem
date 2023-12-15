package com.java.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.*;
import com.java.model.*;
import com.java.service.PingLunService;
@Service("PingLunService")
public class PingLunServiceiml implements PingLunService {

	private PingLunMapper pinglunMapper;

	public PingLunMapper getAddMapper() {
		return pinglunMapper;
	}
	@Autowired
	public void setAddMapper(PingLunMapper pinglunMapper) {
		this.pinglunMapper = pinglunMapper;
	}
	
	@Override
	public PingLun GetByID(int id) {
		return pinglunMapper.GetByID(id);
	}
	
	@Override
	public int Add(PingLun pinglun) {
		return pinglunMapper.Add(pinglun);
	}
	
	@Override
	public int Del(int id) {
		int result = pinglunMapper.Del(id);
		System.out.println("no:"+result);
		return result;
	}

	@Override
	public List<PingLun> GetByThingID(int jid) {
		return pinglunMapper.GetByThingID(jid);
	}
	
	@Override
	public List<PingLun> GetByClientID(int cid) {
		return pinglunMapper.GetByClientID(cid);
	}

}
