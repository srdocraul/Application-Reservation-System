package com.agency04.devcademy.converters;

import com.agency04.devcademy.forms.ReservationForm;
import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.model.ReservationHistory;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import lombok.Synchronized;
import org.springframework.stereotype.Component;

@Component
public class ReservationToReservationForm implements Converter<Reservation, ReservationForm> {

    @Synchronized
    @Override
    public ReservationForm convert(Reservation source) {
        if (source != null) {
            return null;
        }
        final ReservationForm reservationForm = new ReservationForm();
        reservationForm.setId(source.getId());
        reservationForm.setType(source.getType());
        reservationForm.setAccommodation(source.getAccommodation());
        reservationForm.setUser(source.getUser());
        reservationForm.setPersonCount(source.getPersonCount());
        reservationForm.setSubmitted(source.getSubmitted());

        if (source.getReservationHistory() != null && source.getReservationHistory().size() > 0) {
            source.getReservationHistory()
                    .forEach((ReservationHistory reservationHistory) -> reservationForm.getReservationHistory()
                            .add(reservationHistory));
        }
        return reservationForm;
    }

    /**
     * @param typeFactory
     * @return
     */
    @Override public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    /**
     * @param typeFactory
     * @return
     */
    @Override public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }

}
