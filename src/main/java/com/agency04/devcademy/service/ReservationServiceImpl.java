package com.agency04.devcademy.service;

import com.agency04.devcademy.converters.ReservationFormToReservation;
import com.agency04.devcademy.converters.ReservationToReservationForm;
import com.agency04.devcademy.exceptions.ApiRequestException;
import com.agency04.devcademy.forms.ReservationForm;
import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.model.ReservationHistory;
import com.agency04.devcademy.repository.ReservationHistoryRepository;
import com.agency04.devcademy.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationFormToReservation reservationFormToReservation;
    private final ReservationToReservationForm reservationToReservationForm;

    private final ReservationHistoryRepository reservationHistoryRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  ReservationFormToReservation reservationFormToReservation,
                                  ReservationToReservationForm reservationToReservationForm,
                                  ReservationHistoryRepository reservationHistoryRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationFormToReservation = reservationFormToReservation;
        this.reservationToReservationForm = reservationToReservationForm;
        this.reservationHistoryRepository = reservationHistoryRepository;
    }

    @Override
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

    @Override
    public Reservation findById(Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (reservationOptional.isPresent()) {
            return reservationOptional.get();
        } else throw new ApiRequestException("Reservation not found! For id value: " + id);
    }

    @Override
    public ReservationForm findCommandById(Long id) {
        return reservationToReservationForm.convert(findById(id));
    }

    @Override
    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Reservation not found by this id: " + id));
        reservationRepository.delete(reservation);
    }

    @Override
    public ReservationForm confirmReservation(ReservationForm reservationForm) throws ApiRequestException {
        Optional<Reservation> reservationDb = this.reservationRepository.findById(reservationForm.getId());
        if (reservationDb.isPresent()) {
            Reservation reservationExists = reservationDb.get();

            if (!reservationForm.getCheckIn().after(reservationForm.getCheckOut())) {
                reservationExists.setCheckIn(reservationForm.getCheckIn());
                reservationExists.setCheckOut(reservationForm.getCheckOut());
            } else throw new ApiRequestException("Check In Date Must Be Before Check Out Date!");

            if (reservationForm.getPersonCount() <= reservationExists.getAccommodation().getPersonCount()) {
                reservationExists.setPersonCount(reservationForm.getPersonCount());
                reservationExists.setSubmitted(reservationForm.isSubmitted());
            } else
                throw new ApiRequestException("Maximum Person Allowed Is: " + reservationExists.getAccommodation().getPersonCount());

            if (!reservationExists.getType().equals(reservationForm.getType())) {
                ReservationHistory reservationHistory = new ReservationHistory();
                reservationHistory.setFromType(reservationExists.getType());
                reservationHistory.setToType(reservationForm.getType());
                reservationExists.setType(reservationForm.getType());
                reservationHistory.setEntryTimestamp(new Date());
                reservationExists.addReservationHistory(reservationHistory);

                reservationHistoryRepository.save(reservationHistory);
            }
            reservationRepository.save(reservationExists);
            return reservationToReservationForm.convert(reservationExists);
        } else throw new ApiRequestException("Reservation not found!");
    }
}
