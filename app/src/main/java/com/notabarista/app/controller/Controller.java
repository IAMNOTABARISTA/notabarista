package com.notabarista.app.controller;


import com.notabarista.app.model.User;
import com.notabarista.app.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private AuthenticationService service;

    // sign up feature
    @PostMapping("/signup")
    private User userSignUp(@RequestBody User user) throws Exception {
        // checking the whether the email/username is already used or not
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
}
