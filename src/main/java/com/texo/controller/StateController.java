package com.texo.controller;

import com.texo.DTO.StateInfo;
import com.texo.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    StateService stateService;

    @GetMapping(value = "/mostAndLeastCities")
    public ResponseEntity<List<StateInfo>> getStatesWithMostAndLeastCities() {
        return ResponseEntity.ok().body(stateService.getStatesWithMostAndLeastCities());
    }
}
