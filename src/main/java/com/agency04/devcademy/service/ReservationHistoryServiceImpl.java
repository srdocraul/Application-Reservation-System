package com.agency04.devcademy.service;

import com.agency04.devcademy.exceptions.ApiRequestException;
import com.agency04.devcademy.model.ReservationHistory;
import com.agency04.devcademy.repository.ReservationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationHistoryServiceImpl implements ReservationHistoryService {

    @Autowired
    private ReservationHistoryRepository reservationHistoryRepository;

    @Override
    public ReservationHistory createReservationHistory(ReservationHistory reservationHistory) {
        return reservationHistoryRepository.save(reservationHistory);
    }

    @Override
    public ReservationHistory updateReservationHistory(ReservationHistory reservationHistory) {
        Optional<ReservationHistory> reservationHistoryDb =
                this.reservationHistoryRepository.findById(reservationHistory.getId());
        if (reservationHistoryDb.isPresent()) {
            ReservationHistory reservationHistoryUpdate = reservationHistoryDb.get();
            reservationHistoryUpdate.mapFrom(reservationHistory);
            return reservationHistoryUpdate;
        } else throw new ApiRequestException("Record not found with id : " + reservationHistory.getId());

    }

    @Override
    public List<ReservationHistory> getAllReservationHistory() {
        return this.reservationHistoryRepository.findAll();
    }

    @Override
    public ReservationHistory getReservationHistoryById(Long id) {
        Optional<ReservationHistory> reservationHistoryDb = this.reservationHistoryRepository.findById(id);
        if (reservationHistoryDb.isPresent()) return reservationHistoryDb.get();
        else throw new ApiRequestException("Record not found with id: " + id);
    }

    @Override
    public void deleteReservationHistory(Long id) {
        ReservationHistory reservationHistory = reservationHistoryRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Reservation history not found by this id :: " + id));
        reservationHistoryRepository.delete(reservationHistory);
    }
}
