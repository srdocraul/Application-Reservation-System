package com.agency04.devcademy.configuration;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.AccommodationServiceImpl;
import com.agency04.devcademy.service.MobileHomeAccommodationServiceImpl;
import com.agency04.devcademy.service.RoomAccommodationServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:ara.properties")
@PropertySource("classpath:ara.yml")
@ImportResource("classpath:mobileHomeAccommodationService.xml")
@Configuration
public class AccommodationConfiguration {
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

    public MobileHomeAccommodationServiceImpl mobileHomeAccommodationService() {
        return new MobileHomeAccommodationServiceImpl();
    }

    @Bean
    public RoomAccommodationServiceImpl roomAccommodationService() {
        return new RoomAccommodationServiceImpl();
    }

    @Primary
    @Bean
    public AccommodationServiceImpl accommodationServiceImpl() {
        return new AccommodationServiceImpl();
    }
}
