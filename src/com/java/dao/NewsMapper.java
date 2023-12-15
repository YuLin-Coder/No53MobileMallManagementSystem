package com.java.dao;

import java.util.List;

import com.java.model.News;
import com.java.model.Pages;

public interface NewsMapper {
    int Del(Integer id);

    int Add(News record);


    News GetByID(Integer id);

    int Edit(News record);


    List<News> Get(News n);

	int EditHot(int id);
	int EditZan(int id);

	int GetCount(News n);
}