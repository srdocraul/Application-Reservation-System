package com.agency04.devcademy.repositories;

import com.agency04.devcademy.api.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

}
