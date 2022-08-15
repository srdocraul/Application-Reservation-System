package com.agency04.devcademy.controller;


import com.agency04.devcademy.exceptions.NotFoundException;
import com.agency04.devcademy.model.Users;
import com.agency04.devcademy.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok().body(usersService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsersById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(usersService.getUsersById(id));
    }

    @PostMapping
    public ResponseEntity<Users> createUsers(@RequestBody Users users) {
        return ResponseEntity.ok().body(this.usersService.createUsers(users));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable Long id, @RequestBody Users users) {
        users.setId(id);
        return ResponseEntity.ok().body(this.usersService.updateUsers(users));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUsers(@PathVariable Long id) {
        this.usersService.deleteUsers(id);
        return HttpStatus.OK;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {

        log.error("Handling not found exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
