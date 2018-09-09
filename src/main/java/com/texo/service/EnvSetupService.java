package com.texo.service;

import com.texo.importer.DataImporter;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EnvSetupService {

    @PostConstruct
    public static void init()
    {
        new DataImporter().loadData();
    }


}
