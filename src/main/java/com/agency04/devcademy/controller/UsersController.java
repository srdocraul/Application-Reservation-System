package com.agency04.devcademy.controller;


import com.agency04.devcademy.model.Users;
import com.agency04.devcademy.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
@Tag(name = "users-controller", description = "This is the Users controller")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Operation(summary = "Get All Users", description = "This will get a list of all Users")
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok().body(usersService.getAllUsers());
    }

    @Operation(summary = "Get User By ID", description = "This will get a User by its ID value. The ID must " +
            "exist" +
            " in a Database")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsersById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(usersService.getUsersById(Long.valueOf(id)));
    }

    @Operation(summary = "Save a User", description = "This will save a new User")
    @PostMapping
    public ResponseEntity<Users> createUsers(@RequestBody Users users) {
        return ResponseEntity.ok().body(this.usersService.createUsers(users));
    }

    @Operation(summary = "Update User By ID",
            description = " This will update an existing User by its ID. The " +
                    "ID must exist in a Database")
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable Long id, @RequestBody Users users) {
        users.setId(id);
        return ResponseEntity.ok().body(this.usersService.updateUsers(users));
    }

    @Operation(summary = "Delete a User by its ID", description = "You can delete a User by its ID. The" +
            " ID must exist in a Database!")
    @DeleteMapping("/{id}")
    public HttpStatus deleteUsers(@PathVariable Long id) {
        this.usersService.deleteUsers(id);
        return HttpStatus.OK;
    }
}
