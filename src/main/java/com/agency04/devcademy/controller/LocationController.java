package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.Location;
import com.agency04.devcademy.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationController {

    @Autowired
    private LocationServiceImpl locationServiceImpl;

    @GetMapping("/location")
    public ResponseEntity<List<Location>> getAllLocation() {
        return ResponseEntity.ok().body(locationServiceImpl.getAllLocation());
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<Object> getLocationById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(locationServiceImpl.getLocationById(id));
    }

    @PostMapping("/location")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        return ResponseEntity.ok().body(this.locationServiceImpl.createLocation(location));
    }

    @PutMapping("/location/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        location.setId(id);
        return ResponseEntity.ok().body(this.locationServiceImpl.updateLocation(location));
    }

    @DeleteMapping("/location/{id}")
    public HttpStatus deleteLocation(@PathVariable Long id) {
        this.locationServiceImpl.deleteLocation(id);
        return HttpStatus.OK;
    }
}