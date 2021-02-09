package com.se.hackathon.helper.service;

import com.se.hackathon.helper.entity.User;
import com.se.hackathon.helper.model.request.RegistrationRequest;

public interface UserService {

    User createUser(RegistrationRequest newRegistrationRequest);

    User save(User newUser);

    Boolean existsByEmail(String email);
}
