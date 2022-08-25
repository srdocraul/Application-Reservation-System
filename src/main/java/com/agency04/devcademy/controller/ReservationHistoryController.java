package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.ReservationHistory;
import com.agency04.devcademy.service.ReservationHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations/history")
@Slf4j
@Tag(name = "reservation-history-controller", description = "This is the Reservation History controller")
public class ReservationHistoryController {

    @Autowired
    private ReservationHistoryService reservationHistoryService;

    @Operation(summary = "Get All Reservation History", description = "This will get a list of all Reservation History")
    @GetMapping
    public ResponseEntity<List<ReservationHistory>> getAllReservationHistory() {
        return ResponseEntity.ok().body(reservationHistoryService.getAllReservationHistory());
    }

    @Operation(summary = "Get Reservation History By ID",
            description = "This will get a Reservation History by its ID value. The ID must " +
                    "exist" +
                    " in a Database")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getReservationHistoryById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(reservationHistoryService.getReservationHistoryById(Long.valueOf(id)));
    }

    @Operation(summary = "Save a Reservation History", description = "This will save a new Reservation History")
    @PostMapping
    public ResponseEntity<ReservationHistory> createReservationHistory(@RequestBody ReservationHistory reservationHistory) {
        return ResponseEntity.ok().body(this.reservationHistoryService.createReservationHistory(reservationHistory));
    }

    @Operation(summary = "Delete a Reservation History by its ID",
            description = "You can delete a Reservation History by its ID. The" +
                    " ID must exist in a Database!")
    @DeleteMapping("/{id}")
    public HttpStatus deleteReservationHistory(@PathVariable Long id) {
        this.reservationHistoryService.deleteReservationHistory(id);
        return HttpStatus.OK;
    }
}
