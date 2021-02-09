package com.se.hackathon.helper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se.hackathon.helper.model.enums.RoleName;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role_table")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long id;


    @Column(name = "ROLE_NAME")
    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> userList = new HashSet<>();
}
