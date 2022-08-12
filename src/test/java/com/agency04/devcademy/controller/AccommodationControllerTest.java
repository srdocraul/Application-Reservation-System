package com.agency04.devcademy.controller;

import com.agency04.devcademy.model.Accommodation;
import com.agency04.devcademy.service.AccommodationService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@WebMvcTest(controllers = AccommodationController.class)
class AccommodationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AccommodationService accommodationService;

    @Before
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup().build();
    }

    @Test
    public void shouldGetAllAccommodationRecommendation() throws Exception {
        List<Accommodation> accommodation = accommodationService.getAllAccommodationRecommendation();

        Mockito.when(accommodationService.getAllAccommodation()).thenReturn(accommodation);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/accommodation/recommendation"));
    }
}