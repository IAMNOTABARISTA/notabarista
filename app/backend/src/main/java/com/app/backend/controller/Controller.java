package com.app.backend.controller;


import com.app.backend.model.User;
import com.app.backend.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class Controller {


    @Autowired
    private RegistrationService service;

    // for sign in functionality
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmailId();

        // check whether user with this emailId is already is existed or not
        if (tempEmail != null && !"".equals(tempEmail)) {
            User userObj = service.fetchUserByEmailID(tempEmail);
            if (userObj != null) {
                throw new Exception("Your emailId is already used");
            }
        }
        User userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }


}
