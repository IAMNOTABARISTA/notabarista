package com.app.backend.service;


import com.app.backend.model.User;
import com.app.backend.repo.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository repo;

    public User saveUser(User user) {
        return repo.save(user);
    }

    // to find a specific user with a emailId
    public User fetchUserByEmailID(String email) {
        return repo.findByEmailId(email);
    }

    // for login method, finding user with specific emailId and password combination
    public User fetchUserByEmailIDAndPassword(String email, String password) {
        return repo.findByEmailIdAndPassword(email, password);
    }

    public User fetchUserByUsername(String username) {
        return repo.findByUsername(username);
    }
}
