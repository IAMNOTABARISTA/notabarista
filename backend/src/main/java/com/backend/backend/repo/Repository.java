package com.backend.backend.repo;

import com.backend.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<User, Integer> {

    User findByEmailId(String email);

    User findByUserName(String username);

    User findByEmailIdAndPassword(String email, String password);

    User findByUserNameAndPassword(String userName, String password);
}
