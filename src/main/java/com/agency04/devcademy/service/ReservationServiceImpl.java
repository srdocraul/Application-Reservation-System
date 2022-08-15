package com.agency04.devcademy.service;

import com.agency04.devcademy.commands.ReservationCommand;
import com.agency04.devcademy.converters.ReservationCommandToReservation;
import com.agency04.devcademy.converters.ReservationToReservationCommand;
import com.agency04.devcademy.exceptions.NotFoundException;
import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationCommandToReservation reservationCommandToReservation;
    private final ReservationToReservationCommand reservationToReservationCommand;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  ReservationCommandToReservation reservationCommandToReservation,
                                  ReservationToReservationCommand reservationToReservationCommand) {
        this.reservationRepository = reservationRepository;
        this.reservationCommandToReservation = reservationCommandToReservation;
        this.reservationToReservationCommand = reservationToReservationCommand;
    }

    @Override
    @Transactional
    public ReservationCommand createReservationCommand(ReservationCommand reservationCommand) {
        Reservation detachedReservation = reservationCommandToReservation.convert(reservationCommand);

        Reservation createReservation = reservationRepository.save(detachedReservation);
        return reservationToReservationCommand.convert(createReservation);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return this.reservationRepository.findAll();
    }

    @Override public Reservation findById(Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (!reservationOptional.isPresent()) {
            throw new NotFoundException("Reservation not found! For id value: " + id);
        }
        return reservationOptional.get();
    }

    @Override
    @Transactional
    public ReservationCommand findCommandById(Long id) {
        return reservationToReservationCommand.convert(findById(id));
    }


    @Override
    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reservation not found by this id :: " + id));
        reservationRepository.delete(reservation);
    }
}
