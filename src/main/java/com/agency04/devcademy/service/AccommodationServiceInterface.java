package com.agency04.devcademy.service;

import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.model.Accommodation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface AccommodationServiceInterface {

    Accommodation createAccommodation(Accommodation accommodation);

    Accommodation updateAccommodation(Accommodation accommodation);

    List<Accommodation> getAllAccommodation();

    ResponseEntity<Accommodation> getAccommodationById(long id);

    Map< String, Boolean > deleteAccommodation(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException;
}
