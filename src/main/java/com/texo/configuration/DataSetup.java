package com.texo.configuration;

import com.texo.importer.DataImporter;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("dev")
public class DataSetup {

    @PostConstruct
    public static void init()
    {
        new DataImporter().loadData();
    }


}
