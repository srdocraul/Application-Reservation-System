package com.agency04.devcademy.controller;


import com.agency04.devcademy.model.Role;
import com.agency04.devcademy.model.User;
import com.agency04.devcademy.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "users-controller", description = "This is the User controller")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get All User", description = "This will get a list of all User")
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @Operation(summary = "Get User By ID", description = "This will get a User by its ID value. The ID must " +
            "exist" +
            " in a Database")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsersById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(userService.getUsersById(Long.valueOf(id)));
    }

    @Operation(summary = "Save a User", description = "This will save a new User")
    @PostMapping
    public ResponseEntity<User> createUsers(@RequestBody User user) {
        return ResponseEntity.ok().body(this.userService.createUsers(user));
    }

    @Operation(summary = "Update User By ID",
            description = " This will update an existing User by its ID. The " +
                    "ID must exist in a Database")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUsers(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.ok().body(this.userService.updateUsers(user));
    }

    @Operation(summary = "Delete a User by its ID", description = "You can delete a User by its ID. The" +
            " ID must exist in a Database!")
    @DeleteMapping("/{id}")
    public HttpStatus deleteUsers(@PathVariable Long id) {
        this.userService.deleteUsers(id);
        return HttpStatus.OK;
    }

    @Operation(summary = "Save a Role", description = "This will save a new Role")
    @PostMapping("/role")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return ResponseEntity.ok().body(this.userService.createRole(role));
    }

    @Operation(summary = "Save a Role to User", description = "This will add a new Role to an existing User")
    @PostMapping("/role/add")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
