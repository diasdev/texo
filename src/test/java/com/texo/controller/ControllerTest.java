package com.texo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@ActiveProfiles("test")
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCapitals_expectsOK() throws Exception {
        mockMvc.perform(get("/city/capitals").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getCities_withCount_expectsOK() throws Exception {
        mockMvc.perform(get("/city/all").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk()).andExpect(header().longValue("X-Total-Count", 12));
    }

    @Test
    public void getCityById_expectsOK() throws Exception {
        mockMvc.perform(get("/city/4104808").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getCityByUF_withCount_expectsOK() throws Exception {
        mockMvc.perform(get("/city/all?ufcode=RS").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk()).andExpect(header().longValue("X-Total-Count", 5));
    }

    @Test
    public void getStatesWithMostAndLeastCities_expectsOK() throws Exception {
        mockMvc.perform(get("/state/mostAndLeastCities").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    /*@Test
    @Ignore
    public void deleteCity_expectsOK() throws Exception {
        mockMvc.perform(delete("/city/4106902").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());

        mockMvc.perform(get("/city/4106902").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }*/

}
