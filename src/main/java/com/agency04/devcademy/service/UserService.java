package com.agency04.devcademy.service;


import com.agency04.devcademy.model.Role;
import com.agency04.devcademy.model.User;

import java.util.List;

public interface UserService {

    User createUsers(User user);

    Role createRole(Role role);

    void addRoleToUser(String username, String roleName);

    User updateUsers(User user);

    List<User> getAllUsers();

    User getUsersById(Long id);

    void deleteUsers(Long id);
}
