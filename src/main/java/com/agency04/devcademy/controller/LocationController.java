package com.agency04.devcademy.controller;

import com.agency04.devcademy.exceptions.NotFoundException;
import com.agency04.devcademy.model.Location;
import com.agency04.devcademy.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/accommodation/location")
@Slf4j
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocation() {
        return ResponseEntity.ok().body(locationService.getAllLocation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLocationById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(locationService.getLocationById(id));
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        return ResponseEntity.ok().body(this.locationService.createLocation(location));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        location.setId(id);
        return ResponseEntity.ok().body(this.locationService.updateLocation(location));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteLocation(@PathVariable Long id) {
        this.locationService.deleteLocation(id);
        return HttpStatus.OK;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {

        log.error("Handling not found exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
