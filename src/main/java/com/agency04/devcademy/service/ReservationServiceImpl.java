package com.agency04.devcademy.service;

import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Optional<Reservation> reservationDb = this.reservationRepository.findById(reservation.getId());
        if (reservationDb.isPresent()) {
            Reservation reservationUpdate = reservationDb.get();
            reservationUpdate.mapFrom(reservation);
            reservationRepository.save(reservationUpdate);
            return reservationUpdate;
        } else throw new ResourceNotFoundException("Record not found with id : " + reservation.getId());
    }

    @Override
    public List<Reservation> getAllReservation() {
        return this.reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        Optional<Reservation> reservationDb = this.reservationRepository.findById(id);
        if (reservationDb.isPresent())
            return reservationDb.get();
        else throw new ResourceNotFoundException("Record not found with id: " + id);
    }

    @Override
    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation not found by this id :: " + id));
        reservationRepository.delete(reservation);
    }
}
