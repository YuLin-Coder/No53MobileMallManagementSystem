package com.java.dao;

import java.util.List;
import com.java.model.ThingType2;

public interface ThingType2Mapper {
	int Del(Integer id);

    int Add(ThingType2 record);

    ThingType2 GetByID(Integer id);

    int Edit(ThingType2 record);

    List<ThingType2> Get();
}