package com.se.hackathon.helper.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    private boolean corporate;
    private String firstName;
    private String secondName;
    private String email;
    private String country;

    private boolean activated = false;


    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "USER_AUTHORITY", joinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")})
    private Set<Role> roles = new HashSet<>();

}
