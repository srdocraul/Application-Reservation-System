package com.agency04.devcademy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ReservationHistory {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @NotNull
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'")
    @Schema(description = "The reservations history entry timestamp", defaultValue = "Entry Timestamp", required = true)
    private LocalDateTime entryTimestamp;
    @Enumerated(EnumType.STRING)
    @Schema(description = "The reservations history from type", defaultValue = "From Type", required = true)
    private ReservationType fromType;
    @Enumerated(EnumType.STRING)
    @Schema(description = "The reservations history to type", defaultValue = "To Type", required = true)
    private ReservationType toType;

    @ManyToOne
    private Reservation reservation;

    public void mapFrom(ReservationHistory source) {
        this.setEntryTimestamp(source.getEntryTimestamp());
        this.setFromType(source.getFromType());
        this.setToType(source.getToType());
    }
}
