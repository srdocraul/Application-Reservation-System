package com.agency04.devcademy.service;


import com.agency04.devcademy.model.Role;
import com.agency04.devcademy.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
