package com.agency04.devcademy.repository;

import com.agency04.devcademy.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    @Query(
            value = "SELECT * FROM Accommodation acc WHERE acc.categorization = :categorization AND acc.person_count = " +
                    ":personCount",
            nativeQuery = true)
    List<Accommodation> findAllCategorizationAndPersonCount(Integer categorization, Integer personCount);
}
