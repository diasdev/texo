package com.texo.service;

import com.texo.entity.City;
import com.texo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<City> findAll(String UFCode) {
        return cityRepository.findAll(UFCode);
    }

    @Override
    public City findById(long id) {
        return cityRepository.findById(id);
    }

    @Override
    public List<City> findCapitals() {
        return cityRepository.findCapitals(new Sort(Sort.Direction.ASC, "name"));
    }

    @Override
    public void delete(City city) {
        cityRepository.delete(city);
    }
}
