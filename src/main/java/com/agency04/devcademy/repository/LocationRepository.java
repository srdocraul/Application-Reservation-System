package com.agency04.devcademy.repository;

import com.agency04.devcademy.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Set<Location> findByNameAndPostalCode(String name, Integer postalCode);
}
