package com.app.backend.repo;

import com.app.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Integer> {
}
