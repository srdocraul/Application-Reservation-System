package com.agency04.devcademy.configuration;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:ara.properties")
@PropertySource("classpath:ara.yml")
@Configuration
public class ApplicationConfiguration {
    @Bean
    public Accommodation accommodation(@Value("${accommodation.owner.name}") String ownerName,
                                       @Value("${accommodation.owner.facebook}") String hasFacebook,
                                       @Value("${accommodation.owner.instagram}") String hasInstagram) {
        Accommodation accommodation = new Accommodation();
        accommodation.setOwnerName(ownerName);
        accommodation.setLinkForFacebook(hasFacebook);
        accommodation.setLinkForInstagram(hasInstagram);
        System.out.println("Owner name: " + accommodation.getOwnerName());
        System.out.println("Facebook link: " + accommodation.getLinkForFacebook());
        System.out.println("Instagram link: " + accommodation.getLinkForInstagram());
        return accommodation;
    }

    @Primary
    @Bean
    public AccommodationServiceImpl accommodationService() {
        return new AccommodationServiceImpl();
    }

    @Bean
    public LocationServiceImpl locationService() {
        return new LocationServiceImpl();
    }

    @Bean
    public ReservationServiceImpl reservationService() {
        return new ReservationServiceImpl();
    }

    @Bean
    public UsersServiceImpl usersService() {
        return new UsersServiceImpl();
    }

    @Bean
    public ReservationHistoryServiceImpl reservationHistoryService() {
        return new ReservationHistoryServiceImpl();
    }

    @Bean RecommendationServiceImpl recommendationService() {
        return new RecommendationServiceImpl();
    }
}
