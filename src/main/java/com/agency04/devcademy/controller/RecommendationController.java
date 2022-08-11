package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/accommodation/recommendation")
    public ResponseEntity<List<Accommodation>> getAllAccommodation() {
        return ResponseEntity.ok().body(recommendationService.getAllRecommendation());
    }
}
