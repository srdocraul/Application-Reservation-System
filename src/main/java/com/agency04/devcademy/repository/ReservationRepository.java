package com.agency04.devcademy.repository;

import com.agency04.devcademy.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
