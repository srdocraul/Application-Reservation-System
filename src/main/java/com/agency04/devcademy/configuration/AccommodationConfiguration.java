package com.agency04.devcademy.configuration;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.AccommodationServiceImpl;
import com.agency04.devcademy.service.MobileHomeAccommodationServiceImpl;
import com.agency04.devcademy.service.RoomAccommodationServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:application.properties")
@ImportResource("classpath:mobileHomeAccommodationService.xml")
@Configuration
public class AccommodationConfiguration {

    @Bean
    Accommodation accommodation(@Value("${accommodation.owner.name}") String ownerName) {
        Accommodation accommodation = new Accommodation();
        accommodation.setOwnerName(ownerName);
        System.out.println("Owner name " + accommodation.getOwnerName());
        return accommodation;
    }

    MobileHomeAccommodationServiceImpl mobileHomeAccommodationService() {
        return new MobileHomeAccommodationServiceImpl();
    }

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
