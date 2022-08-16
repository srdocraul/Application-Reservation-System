package com.agency04.devcademy.controller;

import com.agency04.devcademy.exceptions.ReservationNotPossibleException;
import com.agency04.devcademy.forms.ReservationForm;
import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@Slf4j
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservation() {
        log.debug("Get all reservations");
        return ResponseEntity.ok().body(reservationService.getAllReservation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getReservationById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(reservationService.findCommandById(Long.valueOf(id)));
    }

    @PostMapping
    public ResponseEntity<ReservationForm> createReservationCommand(
            @RequestBody @Valid ReservationForm reservationForm) {
        try {
            return ResponseEntity.ok().body(this.reservationService.createReservationCommand(reservationForm));
        } catch (ReservationNotPossibleException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Check your input and try again!", ex);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationForm> updateReservation(@PathVariable Long id,
                                                             @RequestBody ReservationForm reservationForm) {
        reservationForm.setId(id);
        return ResponseEntity.ok().body(this.reservationService.createReservationCommand(reservationForm));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteReservation(Long id) {
        this.reservationService.deleteReservation(id);
        return HttpStatus.OK;
    }
}
