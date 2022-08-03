package com.agency04.devcademy.repository;

import com.agency04.devcademy.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FindByNameAndPostalCode extends JpaRepository<Location, Long> {
    //  @Query("select location from Location where location.name = :#{#req.name} and location.postalCode = :#{#req.postalCode}")
    // Optional<Location> findByNameAndPostalCodeLocation(@Param("req") Location req);
    Optional<Location> findByNameAndPostalCode(String name, Integer postalCode);
}
