package com.agency04.devcademy.bootstrap;

import com.agency04.devcademy.api.Accommodation;
import com.agency04.devcademy.api.Apartment;
import com.agency04.devcademy.repositories.AccommodationRepository;
import com.agency04.devcademy.repositories.ApartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {
    private final ApartmentRepository apartmentRepository;
    private final AccommodationRepository accommodationRepository;

    public BootStrapData(ApartmentRepository apartmentRepository, AccommodationRepository accommodationRepository) {
        this.apartmentRepository = apartmentRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Apartment app = new Apartment(123,12333,"www.imageUrl.com",true,20.45);
        Accommodation acc = new Accommodation("String","Stringgg","Stringggss");
    }
}
