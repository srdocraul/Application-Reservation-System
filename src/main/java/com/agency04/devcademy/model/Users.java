package com.agency04.devcademy.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
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

    public void mapFrom(Users source) {
        this.setFirstName(source.getFirstName());
        this.setLastName(source.getLastName());
        this.setEmail(source.getEmail());
    }
}
