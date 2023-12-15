package com.java.service;



import java.util.List;

import com.java.model.*;

public interface ThingTypeService {

	public int Add(ThingType j);
	public int Edit(ThingType j);
	public ThingType GetByID(int id);
	public int Del(int id);
	public List<ThingType> Get();

}
