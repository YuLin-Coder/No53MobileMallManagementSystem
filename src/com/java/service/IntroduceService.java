package com.java.service;



import java.util.List;

import com.java.model.*;

public interface IntroduceService {

	public int Edit(Introduce j);
	public Introduce GetByID(int id);
	public List<Introduce> Get();

}
