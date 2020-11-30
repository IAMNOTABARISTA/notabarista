package com.notabarista.app.model;


import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    //email
    @NonNull
    @Min(4)
    @Max(15)
    private String emailId;


    //name
    @NonNull
    @Pattern(regexp="^[a-zA-Z]")
    @Min(4)
    @Max(30)
    private String name;

    //usertype
    @NonNull
    @Pattern(regexp="^[a-z]")
    @Max(4)
    private String userType;

    // username
    @NonNull
    @Pattern(regexp="^[a-z]")
    @Min(4)
    @Max(10)
    private String userName;

    // password
    @NonNull
    @Min(6)
    @Max(12)
    private String password;

    public User() {
    }

    public User(UUID id, String emailId, String name, String userType, String userName, String password) {
        this.id = id;
        this.emailId = emailId;
        this.name = name;
        this.userType = userType;
        this.userName = userName;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
