package com.java.dao;

import java.util.List;

import com.java.model.ThingType;

public interface ThingTypeMapper {
	int Del(Integer id);

    int Add(ThingType record);

    ThingType GetByID(Integer id);

    int Edit(ThingType record);

    List<ThingType> Get();
}