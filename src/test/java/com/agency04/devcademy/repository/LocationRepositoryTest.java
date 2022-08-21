package com.agency04.devcademy.repository;

import com.agency04.devcademy.model.Location;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class LocationRepositoryTest {

    @Autowired
    private LocationRepository locationRepository;

    @AfterEach
    void tearDown() {
        locationRepository.deleteAll();
    }

    @Test
    void findLocation() {
        String title = "Grad1";
        Integer postalCode = 1000;

        Location location1 = new Location(
                title,
                "Subtitile",
                postalCode = 4100
        );
        Location location2 = new Location(
                title,
                "Subtitile",
                postalCode = 5200
        );

        locationRepository.save(location1);

        if (!location1.equals(location2)) {
            locationRepository.save(location1);
        } else throw new RuntimeException("Error, data already exist!");
    }
}