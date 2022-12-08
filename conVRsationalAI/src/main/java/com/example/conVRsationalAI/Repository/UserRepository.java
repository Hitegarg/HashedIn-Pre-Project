package com.example.conVRsationalAI.Repository;

import com.example.conVRsationalAI.Entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserCredentials,Long> {
    UserCredentials findByUsername(String username);
    Boolean existsByUsername(String username);
    UserCredentials findById(long id);
}
