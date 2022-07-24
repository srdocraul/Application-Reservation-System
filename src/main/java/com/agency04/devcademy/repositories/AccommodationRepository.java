package com.agency04.devcademy.repositories;

import com.agency04.devcademy.api.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

}
