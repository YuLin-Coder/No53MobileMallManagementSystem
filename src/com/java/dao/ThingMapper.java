package com.java.dao;

import java.util.List;

import com.java.model.Thing;

public interface ThingMapper {
    int Del(Integer id);

    int Add(Thing record);


    Thing GetByID(Integer id);

    List<Thing> Get(Thing record);

    int GetCount(Thing record);

    int Edit(Thing record);
    int EditNum(Thing record);
}