package com.java.service;



import java.util.List;

import com.java.model.*;

public interface ThingType2Service {

	public int Add(ThingType2 j);
	public int Edit(ThingType2 j);
	public ThingType2 GetByID(int id);
	public int Del(int id);
	public List<ThingType2> Get();

}
