package com.agency04.devcademy.controllers;

import com.agency04.devcademy.repositories.ApartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApartmentController {

    private final ApartmentRepository apartmentRepository;

    public ApartmentController(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @RequestMapping("/apartments")
    public String getApartment(Model model ){

        model.addAttribute("apartments", apartmentRepository.findAll());

        return "apartments/list";
    }
}
