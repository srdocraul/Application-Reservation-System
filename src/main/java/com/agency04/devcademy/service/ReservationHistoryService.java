package com.agency04.devcademy.service;

import com.agency04.devcademy.model.ReservationHistory;

import java.util.List;

public interface ReservationHistoryService {
    ReservationHistory createReservationHistory(ReservationHistory reservationHistory);

    ReservationHistory updateReservationHistory(ReservationHistory reservationHistory);

    List<ReservationHistory> getAllReservationHistory();

    ReservationHistory getReservationHistoryById(Long id);

    void deleteReservationHistory(Long id);
}
