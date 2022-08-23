package com.agency04.devcademy.controller;


import com.agency04.devcademy.security.SecurityConfiguration;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Slf4j
@Tag(name = "login-controller", description = "This is the Login controller")
public class LoginController {
    private final SecurityConfiguration securityConfiguration;

    public LoginController(SecurityConfiguration securityConfiguration) {
        this.securityConfiguration = securityConfiguration;
    }

    @Operation(summary = "Save Login", description = "This will save a new Login of user")
    @PostMapping
    public HttpStatus saveNewLogin() throws Exception {
        if (securityConfiguration.authenticationManagerBean() != null) {
            log.info("Successful save of a new login!");
            return HttpStatus.OK;
        } else
            return HttpStatus.BAD_REQUEST;
    }
}
