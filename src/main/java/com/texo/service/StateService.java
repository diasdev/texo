package com.texo.service;

import com.texo.DTO.StateInfo;

import java.util.List;

public interface StateService {

    public List<StateInfo> getStatesWithMostAndLeastCities();
}
