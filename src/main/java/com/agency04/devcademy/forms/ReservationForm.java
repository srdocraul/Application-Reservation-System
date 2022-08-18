package com.agency04.devcademy.forms;

import com.agency04.devcademy.model.ReservationType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @Validated public class ReservationForm {
    private Long id;

    @NotNull @Enumerated(EnumType.STRING) private ReservationType type;

    @NotNull @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'") private LocalDateTime checkIn;

    @NotNull @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'") private LocalDateTime checkOut;

    @Min(value = 1) @Max(value = 500) @NotNull private Integer personCount;

    @NotNull @Column(columnDefinition = "BOOLEAN DEFAULT true") private Boolean submitted;
}
