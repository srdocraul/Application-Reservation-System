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
public class Reservation extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @Enumerated(EnumType.STRING)
    private ReservationType type;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'")
    private LocalDateTime checkIn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'")
    private LocalDateTime checkOut;
    private Integer personCount;
    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean submitted;

    @ManyToOne
    private Accommodation accommodation;
    @ManyToOne
    private Users users;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ReservationHistory reservationHistory;
}
