package com.agency04.devcademy.configuration;

import com.agency04.devcademy.service.AccommodationServiceImpl;
import com.agency04.devcademy.service.MobileHomeAccommodationServiceImpl;
import com.agency04.devcademy.service.RoomAccommodationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:mobileHomeAccommodationService.xml")
@Configuration
public class AccommodationConfiguration {
    MobileHomeAccommodationServiceImpl mobileHomeAccommodationService() {
        return new MobileHomeAccommodationServiceImpl();
    }
    
    @Bean
    RoomAccommodationServiceImpl roomAccommodationService() {
        return new RoomAccommodationServiceImpl();
    }

    @Bean
    AccommodationServiceImpl accommodationService() {
        return new AccommodationServiceImpl();
    }
}
