package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.Location;
import com.agency04.devcademy.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accommodation/location")
@Slf4j
@Tag(name = "location-controller", description = "This is the Location controller")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Operation(summary = "Get All Locations", description = "This will get a list of all Locations")
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocation() {
        return ResponseEntity.ok().body(locationService.getAllLocation());
    }

    @Operation(summary = "Get Location By ID", description = "This will get an Location by its ID value. The ID must " +
            "exist" +
            " in a Database")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getLocationById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(locationService.getLocationById(Long.valueOf(id)));
    }

    @Operation(summary = "Save a Location", description = "This will save a new Location")
    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        return ResponseEntity.ok().body(this.locationService.createLocation(location));
    }

    @Operation(summary = "Update Location By ID",
            description = " This will update an existing Location by its ID. The " +
                    "ID must exist in a Database")
    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        location.setId(id);
        return ResponseEntity.ok().body(this.locationService.updateLocation(location));
    }

    @Operation(summary = "Delete a Location by its ID", description = "You can delete a Location by its ID. The" +
            " ID must exist in a Database!")
    @DeleteMapping("/{id}")
    public HttpStatus deleteLocation(@PathVariable Long id) {
        this.locationService.deleteLocation(id);
        return HttpStatus.OK;
    }
}
