package com.agency04.devcademy.bootstrap;

import com.agency04.devcademy.api.Accommodation;
import com.agency04.devcademy.repositories.AccommodationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner{

    private final AccommodationRepository accommodationRepository;
    public BootStrapData(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
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

        accommodationRepository.save(accommodation);
        accommodationRepository.save(accommodation2);

        System.out.println(accommodationRepository.count());


    }
}
