package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accommodation")
public class AccommodationController {
    @Autowired
    private AccommodationService accommodationService;

    @GetMapping
    public ResponseEntity<List<Accommodation>> getAllAccommodation() {
        return ResponseEntity.ok().body(accommodationService.getAllAccommodation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAccommodationById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(accommodationService.getAccommodationById(id));
    }

    //Find by location id
    @GetMapping("/location/all/{id}")
    public ResponseEntity<Object> findByLocation(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(accommodationService.findByLocation(id));
    }

    @PostMapping
    public ResponseEntity<Accommodation> createAccommodation(@RequestBody Accommodation accommodation) {
        return ResponseEntity.ok().body(this.accommodationService.createAccommodation(accommodation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accommodation> updateAccommodation(@PathVariable Long id, @RequestBody Accommodation accommodation) {
        accommodation.setId(id);
        return ResponseEntity.ok().body(this.accommodationService.updateAccommodation(accommodation));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteAccommodation(@PathVariable Long id) {
        this.accommodationService.deleteAccommodation(id);
        return HttpStatus.OK;
    }

    @GetMapping("/recommendation")
    public ResponseEntity<Object> getAllAccommodationRecommendation() {
        return ResponseEntity.ok().body(accommodationService.getAllAccommodationRecommendation());
    }
}
