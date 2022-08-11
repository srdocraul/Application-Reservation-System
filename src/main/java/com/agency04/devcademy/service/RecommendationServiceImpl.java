package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Autowired AccommodationRepository accommodationRepository;

    @Override public List<Accommodation> getAllRecommendation() {
        List<Accommodation> shuffledList = new ArrayList<>();
        shuffledList = accommodationRepository.findAll();
        Collections.shuffle(shuffledList);
        return shuffledList;
    }
}
