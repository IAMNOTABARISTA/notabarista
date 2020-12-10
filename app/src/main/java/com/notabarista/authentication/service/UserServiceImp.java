package com.notabarista.authentication.service;

import com.notabarista.authentication.model.Role;
import com.notabarista.authentication.model.User;
import com.notabarista.authentication.repository.RoleRepository;
import com.notabarista.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImp implements Userservice {

    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user){
// encoding the user password and set it to itself.
        user.setPassword(encoder.encode((user.getPassword())));
        //setting user status
        user.setStatus("VERIFIED");
        // add user role as site user
        Role userRole = roleRepository.findByRole("SITE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public Boolean IsUserAlreadyPresent(User user) {
        boolean userExists = false;
        // search the user in DB
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            userExists = true;
        }
        return userExists;

    }
}
