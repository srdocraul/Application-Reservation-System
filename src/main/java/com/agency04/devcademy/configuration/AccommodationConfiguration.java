package com.agency04.devcademy.configuration;

import com.agency04.devcademy.service.AccommodationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccommodationConfiguration {

    @Bean
    AccommodationServiceImpl accommodationService(){
        return new AccommodationServiceImpl();
    }
}
