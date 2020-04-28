package com.abhishek.patientservice.model;

import com.abhishek.patientservice.service.UserServiceImpl;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final Patient user = UserServiceImpl.user;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public Patient getUser() {
        return user;
    }
}
