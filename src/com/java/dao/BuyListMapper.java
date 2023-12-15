package com.java.dao;

import java.util.List;

import com.java.model.BuyList;

public interface BuyListMapper {
    int Del(Integer id);

    int Add(BuyList record);

    BuyList GetByID(Integer id);
    int GetCount(BuyList record);
    List<BuyList> Get(BuyList record);
}