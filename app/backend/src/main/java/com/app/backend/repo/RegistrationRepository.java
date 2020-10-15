package com.app.backend.repo;

import com.app.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Integer> {
    // to find a user with emailId
    public User findByEmailId(String email);

    public User findByEmailIdAndPassword(String email, String password);

    public User findByUsername(String username);
}
