package com.se.hackathon.helper.service;

import com.se.hackathon.helper.model.UserRequest;
import com.se.hackathon.helper.model.response.UserResponse;

public interface UserService {

    UserResponse saveUser (UserRequest userRequest);
    UserResponse updateUser (Long id, UserRequest userRequest);

    UserResponse getById(Long id);

    void delete(Long id);
}
