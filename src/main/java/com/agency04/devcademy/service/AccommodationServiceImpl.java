package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccommodationServiceImpl implements AccommodationService {
    @Autowired
    private AccommodationRepository accommodationRepository;

    @Override
    public List<Accommodation> getAllAccommodation() {
        return this.accommodationRepository.findAll();
    }

    @Override
    public ResponseEntity<Accommodation> getAccommodationById(long id) {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(accommodation);
    }

    @Override
    public Accommodation createAccommodation(Accommodation accommodation) {
        return accommodationRepository.save((accommodation));
    }

    @Override
    public Accommodation updateAccommodation(Accommodation accommodation) {
        Optional<Accommodation> accommodationDb = this.accommodationRepository.findById(accommodation.getId());

        if (accommodationDb.isPresent()) {
            //TODO: Implement OOP principal on this class
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
