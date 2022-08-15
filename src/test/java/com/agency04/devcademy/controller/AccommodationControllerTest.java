package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.AccommodationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AccommodationControllerTest {
    MockMvc mockMvc;
    @Mock
    AccommodationService accommodationService;
    @InjectMocks
    AccommodationController accommodationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        accommodationController = new AccommodationController();
        mockMvc = MockMvcBuilders.standaloneSetup(accommodationController).build();
        ReflectionTestUtils.setField(accommodationController, "accommodationService", accommodationService);
    }

    @Test
    public void shouldGetAllAccommodationRecommendation() throws Exception {
        List<Accommodation> accommodation = new ArrayList<>();
        when(accommodationService.getAllAccommodationRecommendation()).thenReturn(accommodation);
        mockMvc.perform(get("/accommodation/recommendation")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}