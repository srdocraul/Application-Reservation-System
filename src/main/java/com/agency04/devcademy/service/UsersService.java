package com.agency04.devcademy.service;


import com.agency04.devcademy.model.Users;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UsersService {

    Users createUsers(Users users);

    Users updateUsers(Users users);

    List<Users> getAllUsers();

    Users getUsersById(Long id);

    void deleteUsers(@PathVariable(value = "id") Long id);
}
