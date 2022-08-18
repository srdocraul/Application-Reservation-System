package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Accommodation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AccommodationService {

    Accommodation createAccommodation(Accommodation accommodation);

    Accommodation updateAccommodation(Accommodation accommodation);

    List<Accommodation> getAllAccommodation();

    Accommodation getAccommodationById(Long id);

    List<Accommodation> findByLocation(Long locationId);

    List<Accommodation> getAllAccommodationRecommendation();

    void deleteAccommodation(@PathVariable(value = "id") Long id);

    void saveImageFile(MultipartFile file, Long id);
}
