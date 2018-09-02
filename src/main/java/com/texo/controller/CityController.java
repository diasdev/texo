package com.texo.controller;

import com.texo.entity.City;
import com.texo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("cities")
    public List<City> getAllCities(){
        return cityService.findAll();
    }

}
