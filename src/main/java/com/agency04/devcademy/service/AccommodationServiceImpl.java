package com.agency04.devcademy.service;

import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.Location;
import com.agency04.devcademy.repository.AccommodationRepository;
import com.agency04.devcademy.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class AccommodationServiceImpl implements AccommodationService {
    Location location = new Location();
    @Autowired
    private AccommodationRepository accommodationRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Accommodation> getAllAccommodation() {
        return this.accommodationRepository.findAll();
    }

    public Accommodation getAccommodationById(long id) {
        Optional<Accommodation> accommodationDb = this.accommodationRepository.findById(id);
        if (accommodationDb.isPresent()) {
            return accommodationDb.get();
        } else throw new ResourceNotFoundException("Record not found with id: " + id);
    }

    @Override
    public Accommodation createAccommodation(Accommodation accommodation) {
        List<Location> locationOptional = locationRepository.findByNameAndPostalCode(location.getName(), location.getPostalCode());
        if (locationOptional.isEmpty()) {
            accommodationRepository.save(accommodation);
            locationRepository.save(location);
        } else {
            throw new ResourceNotFoundException("Record already exists : ");
        }
        return accommodation;
    }

    @Override
    public Accommodation updateAccommodation(Accommodation accommodation) {
        Optional<Accommodation> accommodationDb = this.accommodationRepository.findById(accommodation.getId());

        if (accommodationDb.isPresent()) {
            Accommodation accommodationUpdate = accommodationDb.get();
            accommodationUpdate.mapFrom(accommodation);
            accommodationRepository.save(accommodationUpdate);
            return accommodationUpdate;
        } else throw new ResourceNotFoundException("Record not found with id : " + accommodation.getId());
    }

    @Override
    public void deleteAccommodation(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        accommodationRepository.delete(accommodation);
    }
}
