package com.agency04.devcademy.model;

import com.google.common.annotations.GwtCompatible;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

    @Min(1)
    @Max(200)
    @Schema(description = "The users first name", defaultValue = "First Name", required = true)
    private String firstName;
    @Min(1)
    @Max(200)
    @Schema(description = "The users last name", defaultValue = "Last Name", required = true)
    private String lastName;
    @Schema(description = "The users email", defaultValue = "Email", required = true)
    @Email
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
