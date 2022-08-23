package com.agency04.devcademy;

import com.agency04.devcademy.model.Role;
import com.agency04.devcademy.model.User;
import com.agency04.devcademy.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringBootProjectTemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectTemplateApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User("Raul", "Srdoc", "sraul", "1234", new ArrayList<>()));
            userService.saveUser(new User("Marko", "Markic", "mmarko", "1234", new ArrayList<>()));
            userService.saveUser(new User("Ana", "Anic", "aana", "1234", new ArrayList<>()));
            userService.saveUser(new User("David", "Davidovic", "ddavid", "1234", new ArrayList<>()));

            userService.addRoleToUser("sraul", "ROLE_USER");
            userService.addRoleToUser("mmarko", "ROLE_USER");
            userService.addRoleToUser("aana", "ROLE_USER");
            userService.addRoleToUser("ddavid", "ROLE_USER");
            userService.addRoleToUser("sraul", "ROLE_ADMIN");
        };
    }
}


