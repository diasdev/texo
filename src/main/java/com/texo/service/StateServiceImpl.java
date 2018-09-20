package com.texo.service;

import com.texo.DTO.StateInfo;
import com.texo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    StateRepository stateRepository;

    @Override
    public List<StateInfo> getStatesWithMostAndLeastCities() {
        return stateRepository.getStatesWithMostAndLeastCities();
    }
}
