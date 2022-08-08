package com.agency04.devcademy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ReservationHistory extends SuperClass {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'")
    private LocalDateTime entryTimestamp;
    @Enumerated(EnumType.STRING)
    private ReservationType fromType;
    @Enumerated(EnumType.STRING)
    private ReservationType toType;

    @OneToOne
    private Reservation reservation;

    public void mapFrom(ReservationHistory source) {
        this.setEntryTimestamp(source.getEntryTimestamp());
        this.setFromType(source.getFromType());
        this.setToType(source.getToType());
    }
}
