package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.service.ReservationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class ReservationController {

    @Autowired
    private ReservationServiceImpl reservationService;

    @GetMapping("/reservation")
    public ResponseEntity<List<Reservation>> getAllReservation() {
        log.debug("Get all reservations");
        return ResponseEntity.ok().body(reservationService.getAllReservation());
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Object> getReservationById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(reservationService.getReservationById(id));
    }

    @PostMapping("/reservation")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok().body(this.reservationService.createReservation(reservation));
    }

    @PutMapping("/reservation/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        return ResponseEntity.ok().body(this.reservationService.updateReservation(reservation));
    }

    @DeleteMapping("/reservation/{id}")
    public HttpStatus deleteReservation(@PathVariable Long id) {
        this.reservationService.deleteReservation(id);
        return HttpStatus.OK;
    }
}
