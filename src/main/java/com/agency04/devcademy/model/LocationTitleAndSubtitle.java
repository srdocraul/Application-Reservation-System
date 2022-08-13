package com.agency04.devcademy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

@MappedSuperclass
@Data
@NoArgsConstructor
public class LocationTitleAndSubtitle {

    @Size(min = 1, max = 100)
    private String title;
    @Size(min = 1, max = 100)
    private String subtitle;
}
