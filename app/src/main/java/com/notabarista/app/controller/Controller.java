package com.notabarista.app.controller;


import com.notabarista.app.model.User;
import com.notabarista.app.service.AuthenticationService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Validated
public class Controller {
    @Autowired
    private AuthenticationService service;

    // sign up feature
    @PostMapping("/signup")
    private User userSignUp(@Valid @RequestBody User user) throws Exception {
        // checking the whether the email/username is already used or not
        String tempEmail = user.getEmailId();
        String tempUserName = user.getUserName();
        String tempPassword = user.getPassword();
        if (tempEmail != null && !"".equals(tempEmail) && tempUserName != null && !"".equals(tempUserName)) {
            User userObj1 = service.fetchUserByEmailId(tempEmail);
            if (userObj1 != null) {
                throw new Exception(tempEmail + " is already registered");
            }
            User userObj2 = service.fetchUserByUserName(tempUserName);
            if (userObj2 != null) {
                throw new Exception("username " + tempUserName + " is already taken");
            }
        }
        // password encryption
        String encryptedPassword = hashPassword(tempPassword);
        user.setPassword(encryptedPassword);
        User userObj = service.saveUser(user);
        return userObj;
    }

    // password encryption method
    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    // user login  feature
    @PostMapping("/login")
    public User userLogin(@Valid @RequestBody User user) throws Exception {
        String tempEmail = user.getEmailId();
        String plainPassword = user.getPassword();
        String tempUsername = user.getUserName();
        User userObj = null;


        if (plainPassword != null) {
            if (tempUsername == null) {
                userObj = service.fetchUserByEmailId(tempEmail);
            } else {
                userObj = service.fetchUserByUserName(tempUsername);
            }
            if (!(checkPass(plainPassword, userObj.getPassword()))) {
                throw new Exception("bad credentials");
            }
            if (userObj == null) {
                throw new Exception("You are not registered!");
            }

        }
        return userObj;
    }

    // Matching Encrypted and Plain Text Password
    private Boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword))
            return true;
        else
            return false;
    }
}
