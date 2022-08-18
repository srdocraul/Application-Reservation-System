package com.agency04.devcademy.model;

import com.google.common.annotations.GwtCompatible;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
@Data
@NoArgsConstructor
@GwtCompatible
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @Size(min = 1, max = 200)
    private String firstName;
    @Size(min = 1, max = 200)
    private String lastName;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Set<Reservation> reservation;

    public Users(String firstName, String lastName, String email) {
        this.firstName = checkNotNull(firstName, "Enter Your First Name!");
        this.lastName = checkNotNull(lastName, "Enter Your Last Name!");
        this.email = checkNotNull(email, "E-mail is mandatory");
    }

    public void mapFrom(Users source) {
        this.setFirstName(source.getFirstName());
        this.setLastName(source.getLastName());
        this.setEmail(source.getEmail());
    }
}
