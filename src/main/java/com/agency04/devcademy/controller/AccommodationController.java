package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccommodationController {

    @Autowired
    private AccommodationService accommodationService;

    @GetMapping("/accommodations")
    public ResponseEntity<List<Accommodation>> getAllAccommodation(){
        return ResponseEntity.ok().body(accommodationService.getAllAccommodation());
    }

    @GetMapping("/accommodations/{id}")
    public ResponseEntity<ResponseEntity<Accommodation>> getAccommodationById(@PathVariable long id){
        return ResponseEntity.ok().body(accommodationService.getAccommodationById(id));
    }

    @PostMapping("/accommodations")
    public ResponseEntity<Accommodation> createAccommodation(@RequestBody Accommodation accommodation){
        return ResponseEntity.ok().body(this.accommodationService.createAccommodation(accommodation));
    }

    @PutMapping("/accommodations/{id}")
    public ResponseEntity<Accommodation> updateAccommodation(@PathVariable long id,@RequestBody Accommodation accommodation){
        accommodation.setId(id);
        return ResponseEntity.ok().body(this.accommodationService.updateAccommodation(accommodation));
    }

    @DeleteMapping("/accommodations/{id}")
    public HttpStatus deleteAccommodation(@PathVariable long id){
        this.accommodationService.deleteAccommodation(id);
        return HttpStatus.OK;
    }
}


