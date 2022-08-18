package com.agency04.devcademy.converters;

import com.agency04.devcademy.forms.ReservationForm;
import com.agency04.devcademy.model.Reservation;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.stereotype.Component;

@Component public class ReservationToReservationForm implements Converter<Reservation, ReservationForm> {

    @Synchronized @Nullable @Override public ReservationForm convert(Reservation source) {
        if (source != null) {
            final ReservationForm reservationForm = new ReservationForm();
            reservationForm.setId(source.getId());
            reservationForm.setType(source.getType());
            reservationForm.setCheckIn(source.getCheckIn());
            reservationForm.setCheckOut(source.getCheckOut());
            reservationForm.setPersonCount(source.getPersonCount());
            reservationForm.setSubmitted(source.getSubmitted());
            return reservationForm;
        }
        return null;
    }

    @Override public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}
