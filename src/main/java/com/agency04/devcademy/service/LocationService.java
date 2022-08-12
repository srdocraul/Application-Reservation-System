package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Location;

import java.util.List;

public interface LocationService {
    Location createLocation(Location location);

    Location updateLocation(Location location);

    List<Location> getAllLocation();

    Location getLocationById(Long id);

    void deleteLocation(Long id);
}
