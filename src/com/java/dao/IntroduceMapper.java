package com.java.dao;

import java.util.List;

import com.java.model.Introduce;

public interface IntroduceMapper {


    Introduce GetByID(Integer id);

    int Edit(Introduce record);
    
    List<Introduce> Get();
}