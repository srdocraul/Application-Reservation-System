package com.agency04.devcademy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
public class Role {

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    Set<User> users;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Schema(description = "The users name", defaultValue = "Name", required = true)
    private String name;
}
