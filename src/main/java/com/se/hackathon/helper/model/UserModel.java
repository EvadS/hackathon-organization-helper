package com.se.hackathon.helper.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se.hackathon.helper.entity.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;



public class UserModel {

    private Long id;

    private boolean corporate;
    private String firstName;
    private String secondName;
    private String email;
    private String country;

    private boolean activated = false;

    private String password;
    private Set<Role> roles = new HashSet<>();
}
