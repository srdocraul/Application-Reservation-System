package com.agency04.devcademy.repository;

import com.agency04.devcademy.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    @Query(
            value = "SELECT * FROM Accommodations acc WHERE acc.categorization = 3 AND acc.person_count >= 5",
            nativeQuery = true)
    List<Accommodation> findAllCategorizationAndPersonCount();
}
