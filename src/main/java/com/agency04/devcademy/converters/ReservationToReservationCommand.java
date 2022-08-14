package com.agency04.devcademy.converters;

import com.agency04.devcademy.commands.ReservationCommand;
import com.agency04.devcademy.model.Reservation;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.stereotype.Component;

@Component
public class ReservationToReservationCommand implements Converter<Reservation, ReservationCommand> {

    @Synchronized
    @Nullable
    @Override public ReservationCommand convert(Reservation source) {
        if (source != null) {
            final ReservationCommand reservationCommand = new ReservationCommand();
            reservationCommand.setId(source.getId());
            reservationCommand.setType(source.getType());
            reservationCommand.setCheckIn(source.getCheckIn());
            reservationCommand.setCheckOut(source.getCheckOut());
            reservationCommand.setPersonCount(source.getPersonCount());
            reservationCommand.setSubmitted(source.getSubmitted());
            return reservationCommand;
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
