package com.agency04.devcademy.controllers;

import com.agency04.devcademy.repositories.AccommodationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccommodationController {

    private final AccommodationRepository accommodationRepository;

    public AccommodationController(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @RequestMapping("/accommodations")
    public String getAccommodation(Model model ){

        model.addAttribute("accommodations", accommodationRepository.findAll());
        
        return "accommodations";
    }
}
