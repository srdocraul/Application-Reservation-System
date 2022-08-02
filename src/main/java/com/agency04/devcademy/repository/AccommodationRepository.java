package com.agency04.devcademy.repository;

import com.agency04.devcademy.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    @Query("select accommodation from Accommodation accommodation where accommodation.nameLocation = :#{#req. nameLocation} and accommodation.postalCodeLocation = :#{#req.postalCodeLocation}")
    Optional<Accommodation> findAccommodation(@Param("req") Accommodation req);
}
