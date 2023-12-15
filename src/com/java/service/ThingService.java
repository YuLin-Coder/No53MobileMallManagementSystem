package com.java.service;



import java.util.List;

import com.java.model.*;

public interface ThingService {

	public int Add(Thing r);
	public int Edit(Thing r);
	public Thing GetByID(int id);
	public int Del(int id);
	public List<Thing> Get(Thing s);
	public int GetCount(Thing s);
	public int EditNum(Thing r);
}
