package com.agency04.devcademy.service;


import com.agency04.devcademy.model.Role;
import com.agency04.devcademy.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
