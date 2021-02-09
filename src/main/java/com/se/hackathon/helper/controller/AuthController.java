package com.se.hackathon.helper.controller;


import com.se.hackathon.helper.model.User;
import com.se.hackathon.helper.model.request.AuthRequest;
import com.se.hackathon.helper.model.request.RegistrationRequest;
import com.se.hackathon.helper.model.response.AuthResponse;
import com.se.hackathon.helper.security.jwt.JWTFilter;
import com.se.hackathon.helper.security.jwt.TokenProvider;
import com.se.hackathon.helper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        User u = new User();
        u.setPassword(registrationRequest.getPassword());
        u.setEmail(registrationRequest.getLogin());
        userService.saveUser(u);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getEmail());
        return new AuthResponse(token);
    }
}
