/*package com.agency04.devcademy.bootstrap;

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

    public BootStrapData(ApartmentRepository apartmentRepository, Accommodation accommodation, AccommodationRepository accommodationRepository) {
        this.apartmentRepository = apartmentRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Accommodation accommodation1 = new Accommodation("First apartment", "This is subtitle", "This is description");
        Apartment apartment = new Apartment(1,1,"url",true,200.00);

        accommodation1.getApartments().add(apartment);
        apartment.getAccommodation().add(accommodation1);

        accommodationRepository.save(accommodation1);
        apartmentRepository.save(apartment);

        System.out.println("Started in Bootstrap!");
        System.out.println("Number of apartments: " + apartmentRepository.count());

    }
}*/
