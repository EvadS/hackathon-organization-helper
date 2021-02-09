package com.se.hackathon.helper.service.impl;

import com.se.hackathon.helper.model.Role;
import com.se.hackathon.helper.model.User;
import com.se.hackathon.helper.model.UserRequest;
import com.se.hackathon.helper.model.enums.RoleName;
import com.se.hackathon.helper.model.response.UserResponse;
import com.se.hackathon.helper.repository.RoleRepository;
import com.se.hackathon.helper.repository.UserRepository;
import com.se.hackathon.helper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    //TODO:
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        return null;
    }

    //TODO: refactored
    @Override
    public UserResponse saveUser(User user) {

        // TODO: stub before db init script
        Optional<Role> userRoleOpt = roleRepository.findByName("ROLE_USER");
        Role userRole = userRoleOpt.orElseGet(() -> {
            Role role = new Role();
            role.setName(RoleName.ROLE_USER);
            return roleRepository.save(role);
        });

        Set<Role> rolesSet = new HashSet<>();
        rolesSet.add(userRole);
        user.setRoles(rolesSet);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user = userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUserName(user.getEmail());
        return userResponse;
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponse getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        User userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

    // TODO:
    private User findByLogin(String login) {
        return userRepository.findOneByEmail(login).get();
    }

}
