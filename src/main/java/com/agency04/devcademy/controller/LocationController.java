package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.Location;
import com.agency04.devcademy.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/accommodation/location")
    public ResponseEntity<List<Location>> getAllLocation() {
        return ResponseEntity.ok().body(locationService.getAllLocation());
    }

    @GetMapping("/accommodation/location/{id}")
    public ResponseEntity<Object> getLocationById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(locationService.getLocationById(id));
    }

    @PostMapping("/accommodation/location")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        return ResponseEntity.ok().body(this.locationService.createLocation(location));
    }

    @PutMapping("/accommodation/location/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        location.setId(id);
        return ResponseEntity.ok().body(this.locationService.updateLocation(location));
    }

    @DeleteMapping("/accommodation/location/{id}")
    public HttpStatus deleteLocation(@PathVariable Long id) {
        this.locationService.deleteLocation(id);
        return HttpStatus.OK;
    }
}
