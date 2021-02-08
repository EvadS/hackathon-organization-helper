package com.se.hackathon.helper.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // TODO: move to enum
    private String role;
    private boolean corporate;
    private String firstName;
    private String secondName;
    private String email;
    private String country;
}
