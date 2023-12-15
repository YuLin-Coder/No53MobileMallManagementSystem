package com.java.dao;

import java.util.List;

import com.java.model.Buy;

public interface BuyMapper {
    int Del(Integer id);

    int Add(Buy record);

    Buy GetByID(Integer id);

    int GetCount(Buy record);
    int EditState(Buy record);
    List<Buy> Get(Buy record);
}