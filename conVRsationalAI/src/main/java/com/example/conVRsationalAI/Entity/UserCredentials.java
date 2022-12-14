//package com.example.conVRsationalAI.Entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//@Data
//@Entity
//@Table(name = "users")
//public class UserCredentials {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//    private String role;
//    private String username;
//    private String password;
//    private String name;
//
//}
package com.example.conVRsationalAI.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private String token;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime tokenCreationDate;

}
