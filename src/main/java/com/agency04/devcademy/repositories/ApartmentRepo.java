package com.agency04.devcademy.repositories;

import com.agency04.devcademy.api.Apartment;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepo extends CrudRepository<Apartment, Long>{
    
}
