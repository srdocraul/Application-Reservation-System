package com.agency04.devcademy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.annotations.GwtCompatible;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@GwtCompatible
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Schema(description = "The users first name", defaultValue = "First Name", required = true)
    private String firstName;
    @Schema(description = "The users last name", defaultValue = "Last Name", required = true)
    private String lastName;
    @Schema(description = "The users username", defaultValue = "Username", required = true)
    private String username;
    @Schema(description = "The users password", defaultValue = "Password", required = true)
    private String password;
    @Schema(description = "The users email", defaultValue = "Email", required = true)
    @Email
    private String email;

    @OneToMany(cascade = ALL, mappedBy = "user")
    private Set<Reservation> reservation;

    @ManyToMany(fetch = EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private Collection<Role> roles = new ArrayList<>();

    public User(String firstName, String lastName, String email) {
        this.firstName = checkNotNull(firstName, "Enter Your First Name!");
        this.lastName = checkNotNull(lastName, "Enter Your Last Name!");
        this.email = checkNotNull(email, "E-mail is mandatory");
    }

    public void mapFrom(User source) {
        this.setFirstName(source.getFirstName());
        this.setLastName(source.getLastName());
        this.setEmail(source.getEmail());
    }
}
