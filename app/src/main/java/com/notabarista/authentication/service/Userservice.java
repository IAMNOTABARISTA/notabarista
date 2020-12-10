package com.notabarista.authentication.service;
import com.notabarista.authentication.model.User;
public interface Userservice {
    public void saveUser ( User user);
    public Boolean IsUserAlreadyPresent(User user);


}
