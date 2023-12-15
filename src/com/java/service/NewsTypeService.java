package com.java.service;



import java.util.List;

import com.java.model.*;

public interface NewsTypeService {

	public int Add(NewsType j);
	public int Edit(NewsType j);
	public NewsType GetByID(int id);
	public int Del(int id);
	public List<NewsType> Get();

}
