package com.agency04.devcademy.forms;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.model.ReservationHistory;
import com.agency04.devcademy.model.ReservationType;
import com.agency04.devcademy.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ReservationForm {
    private Long id;
    @Schema(description = "The reservations type", defaultValue = "Reservation Type", required = true)
    private ReservationType type;
    @Schema(description = "The reservations check in", defaultValue = "Check In", required = true)
    private java.util.Date checkIn;
    @Schema(description = "The reservations check out", defaultValue = "Check Out", required = true)
    private java.util.Date checkOut;
    @Schema(description = "The reservations person count", defaultValue = "Person Count", required = true)
    private Integer personCount;
    @Schema(description = "The reservations submit", defaultValue = "Submitted", required = true)
    private boolean submitted;
    private Accommodation accommodation;
    private User user;
    private Set<ReservationHistory> reservationHistory = new HashSet<>();

    public void mapFrom(ReservationForm source) {
        this.setType(source.getType());
        this.setCheckIn(source.getCheckIn());
        this.setCheckOut(source.getCheckOut());
        this.setPersonCount(source.getPersonCount());
        this.setSubmitted(source.isSubmitted());
    }
}
