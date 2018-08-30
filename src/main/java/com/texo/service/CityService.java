package com.texo.service;

import com.texo.entity.City;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CityService {
    public List<City> findAll();

    public List<City> findCapitals();

    public void delete(City city);
}
