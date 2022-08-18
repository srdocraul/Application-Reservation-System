package com.agency04.devcademy.service;

import com.agency04.devcademy.exceptions.ApiRequestException;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.Location;
import com.agency04.devcademy.repository.AccommodationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AccommodationServiceImpl implements AccommodationService {
    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private LocationService locationService;


    @Override
    public List<Accommodation> getAllAccommodation() {
        return this.accommodationRepository.findAll();
    }

    public Accommodation getAccommodationById(Long id) {
        Optional<Accommodation> accommodationDb = this.accommodationRepository.findById(id);
        if (accommodationDb.isPresent()) {
            return accommodationDb.get();
        } else throw new ApiRequestException("Record not found with id: " + id);
    }

    @Override
    public Accommodation createAccommodation(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation updateAccommodation(Accommodation accommodation) {
        Optional<Accommodation> accommodationDb = this.accommodationRepository.findById(accommodation.getId());

        if (accommodationDb.isPresent()) {
            Accommodation accommodationUpdate = accommodationDb.get();
            accommodationUpdate.mapFrom(accommodation);
            accommodationRepository.save(accommodationUpdate);
            return accommodationUpdate;
        } else throw new ApiRequestException("Record not found with id : " + accommodation.getId());
    }

    @Override
    public void deleteAccommodation(@PathVariable(value = "id") Long id) throws ApiRequestException {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Accommodation not found by this id :: " + id));
        accommodationRepository.delete(accommodation);
    }

    public Accommodation getAccommodationsLocationById(Long id) {
        Optional<Accommodation> accommodationDb = this.accommodationRepository.findById(id);
        if (accommodationDb.isPresent()) {
            return accommodationDb.get();
        } else throw new ApiRequestException("Record not found with id: " + id);
    }

    @Override public List<Accommodation> getAllAccommodationRecommendation() {
        List<Accommodation> shuffledList = new ArrayList<>();
        shuffledList = accommodationRepository.findAll();
        Collections.shuffle(shuffledList);
        return shuffledList;
    }

    public List<Accommodation> findByLocation(Long locationId) {
        Location location = locationService.getLocationById(locationId);
        return accommodationRepository.findByLocation(location);
    }

    @Override
    public void saveImageFile(MultipartFile file, Long id) {
        try {
            Accommodation accommodation = accommodationRepository.findById(id).get();

            Byte[] bytesObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes())
                bytesObjects[i++] = b;

            accommodation.setImage(bytesObjects);
            accommodationRepository.save(accommodation);

        } catch (IOException e) {
            log.error("Error occurred! ", e);
            e.printStackTrace();
        }
    }
}
