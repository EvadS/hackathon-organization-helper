package com.se.hackathon.helper.repository;

import com.se.hackathon.helper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // TODO:
    Optional<User> findOneByEmail(String lowercaseLogin);

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}