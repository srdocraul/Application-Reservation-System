package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    List<Reservation> getAllReservation();

    Reservation getReservationById(Long id);

    void deleteReservation(Long id);
}
