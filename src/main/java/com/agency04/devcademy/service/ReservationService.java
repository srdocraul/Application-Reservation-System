package com.agency04.devcademy.service;

import com.agency04.devcademy.forms.ReservationForm;
import com.agency04.devcademy.model.Reservation;
import org.webjars.NotFoundException;

import java.util.List;

public interface ReservationService {
    ReservationForm createReservationCommand(ReservationForm reservationForm);

    List<Reservation> getAllReservation();

    Reservation findById(Long id);

    ReservationForm findCommandById(Long id);

    void deleteReservation(Long id);

    ReservationForm confirmReservation(ReservationForm reservationForm) throws Exception;
}
