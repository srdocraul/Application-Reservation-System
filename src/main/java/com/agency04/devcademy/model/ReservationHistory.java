package com.agency04.devcademy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ReservationHistory extends Auditable<String> {

    @OneToOne
    Reservation reservation;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'")
    private LocalDateTime entryTimestamp;
    private ReservationType fromType;
    private ReservationType toType;

    public ReservationHistory(Long id, LocalDateTime entryTimestamp, ReservationType fromType, ReservationType toType) {
        this.id = id;
        this.entryTimestamp = entryTimestamp;
        this.fromType = fromType;
        this.toType = toType;
    }

    public ReservationHistory() {
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getEntryTimestamp() {
        return entryTimestamp;
    }

    public void setEntryTimestamp(LocalDateTime entryTimestamp) {
        this.entryTimestamp = entryTimestamp;
    }

    public ReservationType getFromType() {
        return fromType;
    }

    public void setFromType(ReservationType fromType) {
        this.fromType = fromType;
    }

    public ReservationType getToType() {
        return toType;
    }

    public void setToType(ReservationType toType) {
        this.toType = toType;
    }
}
