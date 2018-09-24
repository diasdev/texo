package com.texo.service;

import com.texo.entity.City;

import java.util.List;

public interface CityService {
    public List<City> findAll(String UFCode);

    City findById(long id);

    public List<City> findCapitals();

    //public List<City> findByState(String UFCode);

    public void delete(City city);
}
