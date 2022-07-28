package com.agency04.devcademy.service;

import com.agency04.devcademy.service.model.Accommodation;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    Accommodation createAccommodation(Accommodation accommodation);

    Accommodation updateAccommodation(Accommodation accommodation);

    List<Accommodation> getAllAccommodation();

    Accommodation getAccommodationById(long id);

    void deleteAccommodation(@PathVariable(value = "id") Long id);
}
