package com.example.conVRsationalAI.Services;

import com.example.conVRsationalAI.Entity.UserCredentials;
import com.example.conVRsationalAI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public boolean usernameExist(String username) {
        return userRepository.existsByUsername(username);
    }
    public UserCredentials insertUserCredentials(UserCredentials user) {
            user.setRole("GENERAL");
            return userRepository.save(user);

    }
    public UserCredentials getUserCredentials(String username){
        return userRepository.findByUsername(username);
    }
    public void deleteCredentials(String username) {
        if (usernameExist(username)) {

            userRepository.deleteById(userRepository.findByUsername(username).getId());
        }
    }
    public boolean usernameexist(String username){
        return userRepository.existsByUsername(username);
    }
    public List<UserCredentials> getAll() {
        return userRepository.findAll();
    }

    public UserCredentials getUser(String username){
        return userRepository.findByUsername(username);
    }

    public UserCredentials updateUserCredentials(UserCredentials userCredentials){
        Optional<UserCredentials> credentials=userRepository.findById(userRepository.findByUsername(userCredentials.getUsername()).getId());
        if(credentials.isEmpty()){
            return new UserCredentials();
        }
//        long user_id = userCredentials.getId();
        userRepository.deleteById(userRepository.findByUsername(userCredentials.getUsername()).getId());
        UserCredentials newuser=credentials.get();
        newuser.setPassword(userCredentials.getPassword());
        newuser.setName(userCredentials.getName());
//        newuser.setId(user_id);
        return userRepository.save(newuser);
    }

}
