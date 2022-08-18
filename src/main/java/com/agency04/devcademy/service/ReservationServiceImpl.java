package com.agency04.devcademy.service;

import com.agency04.devcademy.converters.ReservationFormToReservation;
import com.agency04.devcademy.converters.ReservationToReservationForm;
import com.agency04.devcademy.forms.ReservationForm;
import com.agency04.devcademy.forms.exceptions.ApiRequestException;
import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationFormToReservation reservationFormToReservation;
    private final ReservationToReservationForm reservationToReservationForm;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  ReservationFormToReservation reservationFormToReservation,
                                  ReservationToReservationForm reservationToReservationForm) {
        this.reservationRepository = reservationRepository;
        this.reservationFormToReservation = reservationFormToReservation;
        this.reservationToReservationForm = reservationToReservationForm;
    }

    @Override
    @Transactional
    public ReservationForm createReservationCommand(ReservationForm reservationForm) {

        Reservation detachedReservation = reservationFormToReservation.convert(reservationForm);
        assert detachedReservation != null;
        Reservation createReservation = reservationRepository.save(detachedReservation);
        return reservationToReservationForm.convert(createReservation);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return this.reservationRepository.findAll();
    }

    @Override public Reservation findById(Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (reservationOptional.isEmpty()) {
            throw new ApiRequestException("Reservation not found! For id value: " + id);
        }
        return reservationOptional.get();
    }

    @Override
    @Transactional
    public ReservationForm findCommandById(Long id) {
        return reservationToReservationForm.convert(findById(id));
    }


    @Override
    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Reservation not found by this id :: " + id));
        reservationRepository.delete(reservation);
    }
}
