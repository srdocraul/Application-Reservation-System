package com.agency04.devcademy.repository;

import com.agency04.devcademy.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
