package com.agency04.devcademy.controller;

import com.agency04.devcademy.anotation.ResourceNotFoundException;
import com.agency04.devcademy.api.Accommodation;
import com.agency04.devcademy.repositories.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api")
public class AccommodationController {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @GetMapping("/accommodations/get")
    public List<Accommodation> getAllAccommodations() {
        return accommodationRepository.findAll();
    }

    @GetMapping("/accommodations/get/{id}")
    public ResponseEntity<Accommodation> getAccommodationById(@PathVariable(value = "id") Long id) throws ConfigDataResourceNotFoundException, ResourceNotFoundException {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(accommodation);
    }

    @PostMapping("/accommodations/post")
    public Accommodation save(@RequestBody Accommodation accommodation){
        return accommodationRepository.save(accommodation);

    }

    @PutMapping("/accommodations/put/{id}")
    public ResponseEntity < Accommodation > updateAccommodation(@PathVariable(value = "id") Long id, @RequestBody Accommodation accommodationDetails) throws ResourceNotFoundException {
        Accommodation accommodation2 = accommodationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

       accommodation2.setId(accommodationDetails.getId());
       accommodation2.setTitle(accommodationDetails.getTitle());
       accommodation2.setSubtitle(accommodationDetails.getSubtitle());
       accommodation2.setDescription(accommodationDetails.getDescription());
       accommodation2.setAccommodationType(accommodationDetails.getAccommodationType());
       accommodation2.setCategorization(accommodationDetails.getCategorization());
       accommodation2.setPersonCount(accommodationDetails.getPersonCount());
       accommodation2.setImageUrl(accommodationDetails.getImageUrl());
       accommodation2.setPrice(accommodationDetails.getPrice());

        return new ResponseEntity<>(accommodationRepository.save(accommodation2), OK);
    }

    @DeleteMapping("/accommodations/delete/{id}")
    public Map< String, Boolean > deleteAccommodation(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        accommodationRepository.delete(accommodation);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}


