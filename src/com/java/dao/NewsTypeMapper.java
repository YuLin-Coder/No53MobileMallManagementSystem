package com.java.dao;

import java.util.List;

import com.java.model.NewsType;

public interface NewsTypeMapper {
    int Del(Integer id);

    int Add(NewsType record);


    NewsType GetByID(Integer id);

    int Edit(NewsType record);

    List<NewsType> Get();
}