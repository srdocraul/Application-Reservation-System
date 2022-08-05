package com.agency04.devcademy.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
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

    public Reservation() {
    }

    public Reservation(ReservationType type, LocalDateTime checkIn, LocalDateTime checkOut, Integer personCount, Boolean submitted) {
        this.type = type;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.personCount = personCount;
        this.submitted = submitted;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public ReservationHistory getReservationHistory() {
        return reservationHistory;
    }

    public void setReservationHistory(ReservationHistory reservationHistory) {
        this.reservationHistory = reservationHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReservationType getType() {
        return type;
    }

    public void setType(ReservationType type) {
        this.type = type;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public Boolean getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Boolean submitted) {
        this.submitted = submitted;
    }
}
