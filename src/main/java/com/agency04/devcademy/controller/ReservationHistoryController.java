package com.agency04.devcademy.controller;

import com.agency04.devcademy.exceptions.NotFoundException;
import com.agency04.devcademy.model.ReservationHistory;
import com.agency04.devcademy.service.ReservationHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/reservations/history")
@Slf4j
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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {

        log.error("Handling not found exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
