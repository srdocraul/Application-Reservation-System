package com.agency04.devcademy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class ReservationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'")
    @Schema(description = "The reservations history entry timestamp", defaultValue = "Entry Timestamp", required = true)
    private java.util.Date entryTimestamp;
    @Enumerated(EnumType.STRING)
    @Schema(description = "The reservations history from type", defaultValue = "From Type", required = true)
    private ReservationType fromType;
    @Enumerated(EnumType.STRING)
    @Schema(description = "The reservations history to type", defaultValue = "To Type", required = true)
    private ReservationType toType;

    @ManyToOne
    private Reservation reservation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservationHistory that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
