package com.agency04.devcademy.service;

import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.model.Location;
import com.agency04.devcademy.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location createLocation(Location location) {
        Optional<Location> locationOptional = locationRepository.findLocation(location);
        if (locationOptional.isPresent()) {
            System.out.println("Record exists!");
            return locationOptional.get();
        } else
            locationRepository.save(location);
        return location;
    }

    @Override
    public Location updateLocation(Location location) {
        Optional<Location> locationDb = this.locationRepository.findById(location.getId());
        if (locationDb.isPresent()) {
            Location locationUpdate = locationDb.get();
            locationUpdate.mapFrom(location);
            locationRepository.save(locationUpdate);
            return locationUpdate;
        } else throw new ResourceNotFoundException("Record not found with id : " + location.getId());

    }

    @Override
    public List<Location> getAllLocation() {
        return this.locationRepository.findAll();
    }

    @Override
    public Location getLocationById(Long id) {
        Optional<Location> locationDb = this.locationRepository.findById(id);
        if (locationDb.isPresent())
            return locationDb.get();
        else throw new ResourceNotFoundException("Record not found with id: " + id);
    }

    @Override
    public void deleteLocation(@PathVariable(value = "id") Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found by this id :: " + id));
        locationRepository.delete(location);
    }
}
