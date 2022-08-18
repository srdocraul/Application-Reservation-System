package com.agency04.devcademy.service;

import com.agency04.devcademy.exceptions.ApiRequestException;
import com.agency04.devcademy.model.Users;
import com.agency04.devcademy.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Users createUsers(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users updateUsers(Users users) {
        Optional<Users> usersDb = this.usersRepository.findById(users.getId());
        if (usersDb.isPresent()) {
            Users usersUpdate = usersDb.get();
            usersUpdate.mapFrom(users);
            return usersUpdate;
        } else throw new ApiRequestException("Record not found with id : " + users.getId());
    }

    @Override
    public List<Users> getAllUsers() {
        return this.usersRepository.findAll();
    }

    @Override
    public Users getUsersById(Long id) {
        Optional<Users> usersDb = this.usersRepository.findById(id);
        if (usersDb.isPresent()) return usersDb.get();
        else throw new ApiRequestException("Record not found with id: " + id);
    }

    @Override
    public void deleteUsers(Long id) {
        Users users =
                usersRepository.findById(id).orElseThrow(() -> new ApiRequestException("User not found by this id :: " + id));
        usersRepository.delete(users);
    }
}
