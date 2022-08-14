package com.agency04.devcademy.commands;

import com.agency04.devcademy.model.ReservationType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReservationCommand {

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
}
