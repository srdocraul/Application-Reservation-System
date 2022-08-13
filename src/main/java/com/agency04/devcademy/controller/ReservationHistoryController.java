package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.ReservationHistory;
import com.agency04.devcademy.service.ReservationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations/history")
public class ReservationHistoryController {

    @Autowired
    private ReservationHistoryService reservationHistoryService;

    @GetMapping
    public ResponseEntity<List<ReservationHistory>> getAllReservationHistory() {
        return ResponseEntity.ok().body(reservationHistoryService.getAllReservationHistory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getReservationHistoryById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(reservationHistoryService.getReservationHistoryById(id));
    }

    @PostMapping
    public ResponseEntity<ReservationHistory> createReservationHistory(@RequestBody ReservationHistory reservationHistory) {
        return ResponseEntity.ok().body(this.reservationHistoryService.createReservationHistory(reservationHistory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationHistory> updateReservationHistory(@PathVariable Long id,
                                                                       @RequestBody ReservationHistory reservationHistory) {
        reservationHistory.setId(id);
        return ResponseEntity.ok().body(this.reservationHistoryService.updateReservationHistory(reservationHistory));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteReservationHistory(@PathVariable Long id) {
        this.reservationHistoryService.deleteReservationHistory(id);
        return HttpStatus.OK;
    }
}
