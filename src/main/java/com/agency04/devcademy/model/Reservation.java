package com.agency04.devcademy.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "The reservations type", defaultValue = "Reservation Type", required = true)
    @Enumerated(EnumType.STRING)
    private ReservationType type;
    @Schema(description = "The reservations check in", defaultValue = "Check In", required = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date checkIn;
    @Schema(description = "The reservations check out", defaultValue = "Check Out", required = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date checkOut;
    @Schema(description = "The reservations person count", defaultValue = "Person Count", required = true)
    @Min(1)
    private Integer personCount;
    @Schema(description = "The reservations submit", defaultValue = "Submitted", required = true)
    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean submitted;

    @ManyToOne
    private Accommodation accommodation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservation")
    @ToString.Exclude
    private Set<ReservationHistory> reservationHistory =
            new HashSet<>();

    public void mapFrom(Reservation source) {
        this.setType(source.getType());
        this.setCheckIn(source.getCheckIn());
        this.setCheckOut(source.getCheckOut());
        this.setPersonCount(source.getPersonCount());
        this.setSubmitted(source.getSubmitted());
    }

    public Reservation addReservationHistory(ReservationHistory reservationHistory) {
        reservationHistory.setReservation(this);
        this.reservationHistory.add(reservationHistory);
        return this;
    }
}
