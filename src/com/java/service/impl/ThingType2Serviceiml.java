package com.java.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.*;
import com.java.model.*;
import com.java.service.ThingType2Service;
@Service("ThingType2Service")
public class ThingType2Serviceiml implements ThingType2Service {

	private ThingType2Mapper thingtype2Mapper;

	public ThingType2Mapper getAddMapper() {
		return thingtype2Mapper;
	}
	@Autowired
	public void setAddMapper(ThingType2Mapper thingtype2Mapper) {
		this.thingtype2Mapper = thingtype2Mapper;
	}
	
	@Override    
	public int Edit(ThingType2 thingtype2) {
		return thingtype2Mapper.Edit(thingtype2);
	}
	
	@Override
	public ThingType2 GetByID(int id) {
		return thingtype2Mapper.GetByID(id);
	}
	
	@Override
	public int Add(ThingType2 thingtype2) {
		return thingtype2Mapper.Add(thingtype2);
	}
	
	@Override
	public int Del(int id) {
		int result = thingtype2Mapper.Del(id);
		System.out.println("no:"+result);
		return result;
	}

	@Override
	public List<ThingType2> Get() {
		return thingtype2Mapper.Get();
	}
	

}
