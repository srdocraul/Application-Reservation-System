package com.agency04.devcademy.converters;

import com.agency04.devcademy.forms.ReservationForm;
import com.agency04.devcademy.model.Reservation;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import lombok.Synchronized;
import org.springframework.stereotype.Component;

@Component
public class ReservationFormToReservation implements Converter<ReservationForm, Reservation> {

    @Synchronized
    @Override
    public Reservation convert(ReservationForm source) {
        if (source == null) {
            return null;
        }

        final Reservation reservation = new Reservation();
        reservation.setId(source.getId());
        reservation.setType(source.getType());
        reservation.setPersonCount(source.getPersonCount());
        reservation.setSubmitted(source.isSubmitted());
        reservation.setAccommodation(source.getAccommodation());
        reservation.setUser(source.getUser());
        return reservation;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}
