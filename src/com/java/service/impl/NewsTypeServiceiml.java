package com.java.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.*;
import com.java.model.*;
import com.java.service.NewsTypeService;
@Service("NewsTypeService")
public class NewsTypeServiceiml implements NewsTypeService {

	private NewsTypeMapper newstypeMapper;

	public NewsTypeMapper getAddMapper() {
		return newstypeMapper;
	}
	@Autowired
	public void setAddMapper(NewsTypeMapper newstypeMapper) {
		this.newstypeMapper = newstypeMapper;
	}
	
	@Override    
	public int Edit(NewsType newstype) {
		return newstypeMapper.Edit(newstype);
	}
	
	@Override
	public NewsType GetByID(int id) {
		return newstypeMapper.GetByID(id);
	}
	
	@Override
	public int Add(NewsType newstype) {
		return newstypeMapper.Add(newstype);
	}
	
	@Override
	public int Del(int id) {
		int result = newstypeMapper.Del(id);
		System.out.println("no:"+result);
		return result;
	}

	@Override
	public List<NewsType> Get() {
		return newstypeMapper.Get();
	}

}
