package com.agency04.devcademy.controller;

import com.agency04.devcademy.commands.ReservationCommand;
import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ReservationCommand> createReservationCommand(@RequestBody ReservationCommand reservationCommand) {
        return ResponseEntity.ok().body(this.reservationService.createReservationCommand(reservationCommand));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationCommand> updateReservation(@PathVariable Long id,
                                                                @RequestBody ReservationCommand reservationCommand) {
        reservationCommand.setId(id);
        return ResponseEntity.ok().body(this.reservationService.createReservationCommand(reservationCommand));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteReservation(Long id) {
        this.reservationService.deleteReservation(id);
        return HttpStatus.OK;
    }
}
