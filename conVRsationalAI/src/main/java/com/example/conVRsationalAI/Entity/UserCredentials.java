package com.example.conVRsationalAI.Entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "users")
public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String role;
    private String username;
    private String password;
    private String name;

}
