package com.agency04.devcademy.controller;

import com.agency04.devcademy.forms.ReservationForm;
import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@Slf4j
@Tag(name = "reservation-controller", description = "This is the Reservation controller")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Operation(summary = "Get All Reservations", description = "This will get a list of all Reservations")
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservation() {
        log.debug("Get all reservations");
        return ResponseEntity.ok().body(reservationService.getAllReservation());
    }

    @Operation(summary = "Get Reservation By ID", description = "This will get a Reservation by its ID value. The ID must exist" +
            " in a Database")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getReservationById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(reservationService.findCommandById(Long.valueOf(id)));
    }

    @Operation(summary = "Save a Reservation", description = "This will save a new Reservation")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservationForm> createReservationCommand(@RequestBody @Valid ReservationForm reservationForm) {
        return ResponseEntity.ok().body(this.reservationService.createReservationCommand(reservationForm));
    }

    @Operation(summary = "Update Reservation By ID", description = " This will update an existing Reservation by its ID. The " +
            "ID must exist in a Database")
    @PutMapping("/{id}")
    public ResponseEntity<ReservationForm> updateReservation(@PathVariable Long id,
                                                             @RequestBody ReservationForm reservationForm) {
        reservationForm.setId(id);
        return ResponseEntity.ok().body(this.reservationService.createReservationCommand(reservationForm));
    }

    @Operation(summary = "Delete a Reservation by its ID", description = "You can delete a Reservation by its ID. The" +
            " ID must exist in a Database!")
    @DeleteMapping("/{id}")
    public HttpStatus deleteReservation(Long id) {
        this.reservationService.deleteReservation(id);
        return HttpStatus.OK;
    }
}
