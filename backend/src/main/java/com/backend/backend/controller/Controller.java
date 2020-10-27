package com.backend.backend.controller;


import com.backend.backend.model.User;
import com.backend.backend.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private RegistrationService service;

    // sign in feature
    @PostMapping("/register")
    public User registration(@RequestBody User user) throws Exception {

        // check whether the user email and username is already registered or not
        String tempEmail = user.getEmailId();
        String tempUserName = user.getUserName();

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
        User userObj = service.saveUser(user);
        return userObj;
    }

    // login feature

}
