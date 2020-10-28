package com.notabarista.app.repository;

import com.notabarista.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepo extends JpaRepository<User, Integer> {
    User findByUserName(String username);

    User findByEmailId(String email);
}
