package com.agency04.devcademy.service;

import com.agency04.devcademy.commands.ReservationCommand;
import com.agency04.devcademy.model.Reservation;

import java.util.List;

public interface ReservationService {
    ReservationCommand createReservationCommand(ReservationCommand reservationCommand);

    List<Reservation> getAllReservation();

    Reservation findById(Long id);

    ReservationCommand findCommandById(Long id);

    void deleteReservation(Long id);
}
