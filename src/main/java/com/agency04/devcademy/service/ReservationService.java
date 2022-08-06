package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Reservation;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    List<Reservation> getAllReservation();

    Reservation getReservationById(Long id);

    void deleteReservation(@PathVariable(value = "id") Long id);
}
