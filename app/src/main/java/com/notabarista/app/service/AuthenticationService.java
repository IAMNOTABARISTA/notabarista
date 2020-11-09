package com.notabarista.app.service;


import com.notabarista.app.model.User;
import com.notabarista.app.repository.AuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationRepo repo;

    public User saveUser(User user) {
        // before saving to database we have to sanitize incoming data
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

    public User fetchUserByUserNameAndPassword(String username, String password) {
        return repo.findByUserNameAndPassword(username, password);

    }
}

