package com.agency04.devcademy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@NoArgsConstructor
public class SuperClass {

    @Column(length = 100)
    private String title;
    @Column(length = 200)
    private String subtitle;
}
