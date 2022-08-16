package com.agency04.devcademy.forms;

import com.agency04.devcademy.model.ReservationType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Validated
public class ReservationForm {
    private Long id;

    @NotBlank
    @NotNull
    @Enumerated(EnumType.STRING)
    private ReservationType type;

    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'")
    private LocalDateTime checkIn;

    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'")
    private LocalDateTime checkOut;

    @Size(min = 1, max = 500)
    @NotNull
    private Integer personCount;

    @NotBlank
    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean submitted;
}
