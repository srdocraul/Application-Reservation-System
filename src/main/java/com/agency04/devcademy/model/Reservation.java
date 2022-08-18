package com.agency04.devcademy.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity @Data @NoArgsConstructor @Validated public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Enumerated(EnumType.STRING) private ReservationType type;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'") private LocalDateTime checkIn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'") private LocalDateTime checkOut;
    private Integer personCount;
    @Column(columnDefinition = "BOOLEAN DEFAULT true") private Boolean submitted;

    @ManyToOne
    private Accommodation accommodation;
    @ManyToOne
    private Users users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservation")
    private Set<ReservationHistory> reservationHistory =
            new HashSet<>();

    public void mapFrom(Reservation source) {
        this.setType(source.getType());
        this.setCheckIn(source.getCheckIn());
        this.setCheckOut(source.getCheckOut());
        this.setPersonCount(source.getPersonCount());
        this.setSubmitted(source.getSubmitted());
    }
}
