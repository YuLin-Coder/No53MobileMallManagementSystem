package com.java.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.*;
import com.java.model.*;
import com.java.service.ThingService;
@Service("ThingService")
public class ThingServiceiml implements ThingService {

	private ThingMapper thingMapper;

	public ThingMapper getAddMapper() {
		return thingMapper;
	}
	@Autowired
	public void setAddMapper(ThingMapper thingMapper) {
		this.thingMapper = thingMapper;
	}
	
	@Override    
	public int Edit(Thing thing) {
		return thingMapper.Edit(thing);
	}
	
	@Override    
	public int EditNum(Thing thing) {
		return thingMapper.EditNum(thing);
	}
	
	@Override
	public Thing GetByID(int id) {
		return thingMapper.GetByID(id);
	}
	
	@Override
	public int Add(Thing thing) {
		return thingMapper.Add(thing);
	}
	
	@Override
	public int Del(int id) {
		int result = thingMapper.Del(id);
		return result;
	}

	@Override
	public List<Thing> Get(Thing thing) {
		return thingMapper.Get(thing);
	}
	
	@Override
	public int GetCount(Thing thing) {
		return thingMapper.GetCount(thing);
	}

}
