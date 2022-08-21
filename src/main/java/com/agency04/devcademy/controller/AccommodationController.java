package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.AccommodationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/accommodation")
@Slf4j
@Tag(name = "accommodation-controller", description = "This is the Accommodation controller")
public class AccommodationController {
    @Autowired
    private AccommodationService accommodationService;

    @Operation(summary = "Get All Accommodations", description = "This will get a list of all Accommodations")
    @GetMapping
    public ResponseEntity<List<Accommodation>> getAllAccommodation() {
        return ResponseEntity.ok().body(accommodationService.getAllAccommodation());
    }

    @Operation(summary = "Get Accommodation By ID", description = "This will get an Accommodation by its ID value. The ID must " +
            "exist" +
            " in a Database")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getAccommodationById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(accommodationService.getAccommodationById(Long.valueOf(id)));
    }


    @Operation(summary = "Get Accommodation By Location ID", description = "This will get all Accommodations listed by Location" +
            " ID. The ID must exist in a Database")
    @GetMapping("/location/all/{id}")
    public ResponseEntity<Object> findByLocation(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(accommodationService.findByLocation(id));
    }

    @Operation(summary = "Save a Accommodation", description = "This will save a new Accommodation")
    @PostMapping
    public ResponseEntity<Accommodation> createAccommodation(@RequestBody Accommodation accommodation) {
        return ResponseEntity.ok().body(this.accommodationService.createAccommodation(accommodation));
    }

    @Operation(summary = "Update Accommodation By ID",
            description = " This will update an existing Accommodation by its ID. The " +
                    "ID must exist in a Database")
    @PutMapping("/{id}")
    public ResponseEntity<Accommodation> updateAccommodation(@PathVariable Long id, @RequestBody Accommodation accommodation) {
        accommodation.setId(id);
        return ResponseEntity.ok().body(this.accommodationService.updateAccommodation(accommodation));
    }

    @Operation(summary = "Delete a Accommodation by its ID", description = "You can delete a Accommodation by its ID. The" +
            " ID must exist in a Database!")
    @DeleteMapping("/{id}")
    public HttpStatus deleteAccommodation(@PathVariable Long id) {
        this.accommodationService.deleteAccommodation(id);
        return HttpStatus.OK;
    }

    @Operation(summary = "Get Accommodation Recommendation", description = "This will list Accommodations in a random order on " +
            "every page refresh")
    @GetMapping("/recommendation")
    public ResponseEntity<Object> getAllAccommodationRecommendation() {
        return ResponseEntity.ok().body(accommodationService.getAllAccommodationRecommendation());
    }

    //Image
    @Operation(summary = "Get Accommodation Image By ID", description = "This will get an Accommodation Image by its ID value. " +
            "The ID must exist in a Database")
    @GetMapping("/{id}/image")
    public HttpStatus getImageFile(MultipartFile file, @PathVariable Long id) {
        this.accommodationService.saveImageFile(file, id);
        return HttpStatus.OK;
    }

    @Operation(summary = "Post Accommodation Image By ID", description = "This will post an Accommodation Image by its ID value" +
            ". The ID must exist in a Database")
    @PostMapping("/{id}/image")
    public HttpStatus createImageFile(MultipartFile file, @PathVariable Long id) {
        this.accommodationService.saveImageFile(file, id);
        return HttpStatus.OK;
    }

}
