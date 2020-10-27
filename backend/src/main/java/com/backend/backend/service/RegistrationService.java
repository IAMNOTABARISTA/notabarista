package com.backend.backend.service;


import com.backend.backend.model.User;
import com.backend.backend.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private Repository repo;

    public User saveUser(User user) {
        return repo.save(user);
    }

    public User fetchUserByEmailId(String email) {
        return repo.findByEmailId(email);
    }

    public User fetchUserByUserName(String username) {
        return repo.findByUserName(username);
    }

    public User fetchUserByEmailIDAndPassword(String email, String password) {
        return repo.findByEmailIdAndPassword(email, password);
    }

    public User fetchUserByUserNameAndPassword(String userName, String password) {
        return repo.findByUserNameAndPassword(userName, password);
    }
}
