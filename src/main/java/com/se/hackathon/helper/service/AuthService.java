package com.se.hackathon.helper.service;

import com.se.hackathon.helper.entity.User;
import com.se.hackathon.helper.security.CustomUserDetails;
import com.se.hackathon.helper.model.request.LoginRequest;
import com.se.hackathon.helper.model.request.RegistrationRequest;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface AuthService {
    Optional<User> registerUser(RegistrationRequest newRegistrationRequest);

    Optional<Authentication> authenticateUser(LoginRequest loginRequest);

    String generateToken(CustomUserDetails customUserDetails);
}
