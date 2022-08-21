package com.agency04.devcademy.service;

import com.agency04.devcademy.exceptions.ApiRequestException;
import com.agency04.devcademy.model.Role;
import com.agency04.devcademy.model.User;
import com.agency04.devcademy.repository.RoleRepository;
import com.agency04.devcademy.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User createUsers(User user) {
        log.info("Saving new user to the database");
        return userRepository.save(user);
    }

    @Override
    public Role createRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        log.info("Adding role {} to user {}.", roleName, username);
        user.getRoles().add(role);
    }

    @Override
    public User updateUsers(User user) {
        Optional<User> usersDb = this.userRepository.findById(user.getId());
        if (usersDb.isPresent()) {
            User userUpdate = usersDb.get();
            userUpdate.mapFrom(user);
            return userUpdate;
        } else throw new ApiRequestException("Record not found with id : " + user.getId());
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUsersById(Long id) {
        Optional<User> usersDb = this.userRepository.findById(id);
        if (usersDb.isPresent()) return usersDb.get();
        else throw new ApiRequestException("Record not found with id: " + id);
    }

    @Override
    public void deleteUsers(Long id) {
        User user =
                userRepository.findById(id).orElseThrow(() -> new ApiRequestException("User not found by this id :: " + id));
        userRepository.delete(user);
    }
}
