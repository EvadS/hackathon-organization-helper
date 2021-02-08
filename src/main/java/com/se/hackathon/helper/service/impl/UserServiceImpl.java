package com.se.hackathon.helper.service.impl;

import com.se.hackathon.helper.repository.UserRepository;
import com.se.hackathon.helper.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
