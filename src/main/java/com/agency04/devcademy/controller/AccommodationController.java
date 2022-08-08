package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.AccommodationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccommodationController {
    @Autowired
    private AccommodationServiceImpl accommodationServiceImpl;

    @GetMapping("/accommodation")
    public ResponseEntity<List<Accommodation>> getAllAccommodation() {
        return ResponseEntity.ok().body(accommodationServiceImpl.getAllAccommodation());
    }

    @GetMapping("/accommodation/{id}")
    public ResponseEntity<Object> getAccommodationById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(accommodationServiceImpl.getAccommodationById(id));
    }

    @PostMapping("/accommodation")
    public ResponseEntity<Accommodation> createAccommodation(@RequestBody Accommodation accommodation) {
        return ResponseEntity.ok().body(this.accommodationServiceImpl.createAccommodation(accommodation));
    }

    @PutMapping("/accommodation/{id}")
    public ResponseEntity<Accommodation> updateAccommodation(@PathVariable Long id, @RequestBody Accommodation accommodation) {
        accommodation.setId(id);
        return ResponseEntity.ok().body(this.accommodationServiceImpl.updateAccommodation(accommodation));
    }

    @DeleteMapping("/accommodation/{id}")
    public HttpStatus deleteAccommodation(@PathVariable Long id) {
        this.accommodationServiceImpl.deleteAccommodation(id);
        return HttpStatus.OK;
    }
}
