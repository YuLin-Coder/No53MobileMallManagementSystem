package com.java.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.*;
import com.java.model.*;
import com.java.service.ThingTypeService;
@Service("ThingTypeService")
public class ThingTypeServiceiml implements ThingTypeService {

	private ThingTypeMapper thingtypeMapper;

	public ThingTypeMapper getAddMapper() {
		return thingtypeMapper;
	}
	@Autowired
	public void setAddMapper(ThingTypeMapper thingtypeMapper) {
		this.thingtypeMapper = thingtypeMapper;
	}
	
	@Override    
	public int Edit(ThingType thingtype) {
		return thingtypeMapper.Edit(thingtype);
	}
	
	@Override
	public ThingType GetByID(int id) {
		return thingtypeMapper.GetByID(id);
	}
	
	@Override
	public int Add(ThingType thingtype) {
		return thingtypeMapper.Add(thingtype);
	}
	
	@Override
	public int Del(int id) {
		int result = thingtypeMapper.Del(id);
		System.out.println("no:"+result);
		return result;
	}

	@Override
	public List<ThingType> Get() {
		return thingtypeMapper.Get();
	}
	

}
