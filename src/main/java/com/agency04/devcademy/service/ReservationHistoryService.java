package com.agency04.devcademy.service;

import com.agency04.devcademy.model.ReservationHistory;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ReservationHistoryService {
    ReservationHistory createReservationHistory(ReservationHistory reservationHistory);

    ReservationHistory updateReservationHistory(ReservationHistory reservationHistory);

    List<ReservationHistory> getAllReservationHistory();

    ReservationHistory getReservationHistoryById(Long id);

    void deleteReservationHistory(@PathVariable(value = "id") Long id);
}
