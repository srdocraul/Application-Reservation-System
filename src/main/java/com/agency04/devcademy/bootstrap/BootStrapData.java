package com.agency04.devcademy.bootstrap;

import com.agency04.devcademy.api.Accommodation;
import com.agency04.devcademy.api.Apartment;
import com.agency04.devcademy.repositories.AccommodationRepository;
import com.agency04.devcademy.repositories.ApartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner{

    private final AccommodationRepository accommodationRepository;
    private final ApartmentRepository apartmentRepository;

    public BootStrapData(AccommodationRepository accommodationRepository, ApartmentRepository apartmentRepository) {
        this.accommodationRepository = accommodationRepository;
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Accommodation accommodation = new Accommodation();
        accommodation.setTitle("Title");
        accommodation.setSubtitle("Subtitle");
        accommodation.setDescription("Description");

        Accommodation accommodation2 = new Accommodation();
        accommodation2.setTitle("Ovo je nesto novo");
        accommodation2.setSubtitle("Ovo je jos novije");
        accommodation2.setDescription("Opis tog novog");

        Apartment apartment = new Apartment();
        apartment.setCategorization(1);
        apartment.setFreeCancellation(true);
        apartment.setPrice(1000.0);
        apartment.setPersonCount(20);
        apartment.setImageUrl("image.url");



        accommodationRepository.save(accommodation);
        accommodationRepository.save(accommodation2);
        apartmentRepository.save(apartment);

        System.out.println(accommodationRepository.count());
        System.out.println(apartmentRepository.count());

    }
}
