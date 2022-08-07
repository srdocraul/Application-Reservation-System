package com.agency04.devcademy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ReservationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'")
    private LocalDateTime entryTimestamp;
    @Enumerated(EnumType.STRING)
    private ReservationType fromType;
    @Enumerated(EnumType.STRING)
    private ReservationType toType;

    @OneToOne
    private Reservation reservation;

    @Embedded
    private Audit audit = new Audit();

    public void mapFrom(ReservationHistory source) {
        this.setEntryTimestamp(source.getEntryTimestamp());
        this.setFromType(source.getFromType());
        this.setToType(source.getToType());
    }
}
