package com.example.conVRsationalAI.Entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "users")
public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;
    private String username;
    private String password;
    private String name;
//    private String email;
//    @OneToOne(cascade = CascadeType.ALL)
//    private Profile profile;
}
