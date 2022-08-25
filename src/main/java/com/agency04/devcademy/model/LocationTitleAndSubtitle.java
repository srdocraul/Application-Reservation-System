package com.agency04.devcademy.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationTitleAndSubtitle {
    
    @Schema(description = "Title for used entity", defaultValue = "Title", required = true)
    private String title;
    @Schema(description = "Subtitle for used entity", defaultValue = "Subtitle", required = true)
    private String subtitle;
}
