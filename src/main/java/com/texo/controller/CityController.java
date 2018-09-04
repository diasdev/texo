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
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/all")
    public List<City> getAllCities(){
        return cityService.findAll();
    }

    @GetMapping("/capitals")
    public List<City> getCapitals(){
        return cityService.findCapitals();
    }

    @GetMapping("/by_state")
    public ResponseEntity<List<City>> getCitiesByUFCode(
            @RequestParam(value = "uf_code", required = false) String UFCode) {

        List<City> response = cityService.findByState(UFCode);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Total-Count", String.valueOf(response.size()));

        return ResponseEntity.ok().headers(responseHeaders).body(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathParam(value = "id") long id) {
        City city = cityService.findById(id);

        cityService.delete(city);
    }

}
