package com.texo.controller;

import com.texo.entity.City;
import com.texo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping(value = {"", "/", "/all"})
    public ResponseEntity<List<City>> getAllCities(@RequestParam(value = "ufcode", required = false) String UFCode){

        List<City> response = cityService.findAll(UFCode == null ? null : UFCode.toUpperCase());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Total-Count", String.valueOf(response.size()));

        return ResponseEntity.ok().headers(responseHeaders).body(response);
    }

    @GetMapping("/capitals")
    public List<City> getCapitals(){
        return cityService.findCapitals();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathParam(value = "id") long id) {
        City city = cityService.findById(id);

        cityService.delete(city);
    }

}
