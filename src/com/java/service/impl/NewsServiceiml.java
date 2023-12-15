package com.java.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.*;
import com.java.model.*;
import com.java.service.NewsService;
@Service("NewsService")
public class NewsServiceiml implements NewsService {

	private NewsMapper newsMapper;

	public NewsMapper getAddMapper() {
		return newsMapper;
	}
	@Autowired
	public void setAddMapper(NewsMapper newsMapper) {
		this.newsMapper = newsMapper;
	}
	
	@Override    
	public int Edit(News news) {
		return newsMapper.Edit(news);
	}
	
	@Override    
	public int EditHot(int id) {
		return newsMapper.EditHot(id);
	}
	@Override    
	public int EditZan(int id) {
		return newsMapper.EditZan(id);
	}
	
	@Override
	public News GetByID(int id) {
		return newsMapper.GetByID(id);
	}
	
	@Override
	public int Add(News news) {
		return newsMapper.Add(news);
	}
	
	@Override
	public int Del(int id) {
		int result = newsMapper.Del(id);
		System.out.println("no:"+result);
		return result;
	}

	@Override
	public List<News> Get(News n) {
		return newsMapper.Get(n);
	}

	@Override
	public int GetCount(News n) {
		return newsMapper.GetCount(n);
	}
}
