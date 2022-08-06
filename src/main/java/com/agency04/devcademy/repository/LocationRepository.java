package com.agency04.devcademy.repository;

import com.agency04.devcademy.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("select location from Location location where location.title = :#{#req. title} and location.postalCode = :#{#req.postalCode}")
    Optional<Location> findLocation(@Param("req") Location req);
}
