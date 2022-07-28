package com.agency04.devcademy.controller;

import com.agency04.devcademy.service.model.Accommodation;
import com.agency04.devcademy.service.AccommodationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccommodationController {

    @Autowired
    private AccommodationServiceImpl accommodationServiceImpl;

    @GetMapping("/accommodations")
    public ResponseEntity<List<Accommodation>> getAllAccommodation() {
        return ResponseEntity.ok().body(accommodationServiceImpl.getAllAccommodation());
    }

    @GetMapping("/accommodations/{id}")
    public ResponseEntity<Optional<Accommodation>> getAccommodationById(@PathVariable long id) {
        return ResponseEntity.ok().body(accommodationServiceImpl.getAccommodationById(id));
    }

    @PostMapping("/accommodations")
    public ResponseEntity<Accommodation> createAccommodation(@RequestBody Accommodation accommodation) {
        return ResponseEntity.ok().body(this.accommodationServiceImpl.createAccommodation(accommodation));
    }

    @PutMapping("/accommodations/{id}")
    public ResponseEntity<Accommodation> updateAccommodation(@PathVariable long id, @RequestBody Accommodation accommodation) {
        accommodation.setId(id);
        return ResponseEntity.ok().body(this.accommodationServiceImpl.updateAccommodation(accommodation));
    }

    @DeleteMapping("/accommodations/{id}")
    public HttpStatus deleteAccommodation(@PathVariable long id) {
        this.accommodationServiceImpl.deleteAccommodation(id);
        return HttpStatus.OK;
    }
}
