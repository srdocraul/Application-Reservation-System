package com.agency04.devcademy.controller;


import com.agency04.devcademy.model.Users;
import com.agency04.devcademy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok().body(usersService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUsersById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(usersService.getUsersById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<Users> createUsers(@RequestBody Users users) {
        return ResponseEntity.ok().body(this.usersService.createUsers(users));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable Long id, @RequestBody Users users) {
        users.setId(id);
        return ResponseEntity.ok().body(this.usersService.updateUsers(users));
    }

    @DeleteMapping("/users/{id}")
    public HttpStatus deleteUsers(@PathVariable Long id) {
        this.usersService.deleteUsers(id);
        return HttpStatus.OK;
    }
}
