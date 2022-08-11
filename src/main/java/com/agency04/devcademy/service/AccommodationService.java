package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Accommodation;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AccommodationService {

    Accommodation createAccommodation(Accommodation accommodation);

    Accommodation updateAccommodation(Accommodation accommodation);

    List<Accommodation> getAllAccommodation();

    Accommodation getAccommodationById(Long id);

    List<Accommodation> findByLocation(Long locationId);

    void deleteAccommodation(@PathVariable(value = "id") Long id);
}
