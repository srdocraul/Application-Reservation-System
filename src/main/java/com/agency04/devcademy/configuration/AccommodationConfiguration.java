package com.agency04.devcademy.configuration;

import com.agency04.devcademy.service.AccommodationServiceImpl;
import com.agency04.devcademy.service.MobileHomeAccommodationServiceImpl;
import com.agency04.devcademy.service.RoomAccommodationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;

@ImportResource("classpath:mobileHomeAccommodationService.xml")
@Configuration
public class AccommodationConfiguration {
    @Bean
    RoomAccommodationServiceImpl roomAccommodationService() {
        return new RoomAccommodationServiceImpl();
    }

    @Primary
    @Bean
    AccommodationServiceImpl accommodationService() {
        return new AccommodationServiceImpl();
    }
}
