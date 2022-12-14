//package com.example.conVRsationalAI.Services;
//
//import com.example.conVRsationalAI.Entity.UserCredentials;
//import com.example.conVRsationalAI.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//    @Autowired
//    UserRepository userRepository;
//    public boolean usernameExist(String username) {
//        return userRepository.existsByUsername(username);
//    }
//    public UserCredentials insertUserCredentials(UserCredentials user) {
//            user.setRole("GENERAL");
//            return userRepository.save(user);
//
//    }
//    public UserCredentials getUserCredentials(String username){
//        return userRepository.findByUsername(username);
//    }
//    public void deleteCredentials(String username) {
//        if (usernameExist(username)) {
//
//            userRepository.deleteById(userRepository.findByUsername(username).getId());
//        }
//    }
//    public boolean usernameexist(String username){
//        return userRepository.existsByUsername(username);
//    }
//    public List<UserCredentials> getAll() {
//        return userRepository.findAll();
//    }
//
//    public UserCredentials getUser(String username){
//        return userRepository.findByUsername(username);
//    }
//
////    public UserCredentials updateUserCredentials(UserCredentials userCredentials){
////        Optional<UserCredentials> credentials=userRepository.findById(userRepository.findByUsername(userCredentials.getUsername()).getId());
////        if(credentials.isEmpty()){
////            return new UserCredentials();
////        }
//////        long user_id = userCredentials.getId();
////        userRepository.deleteById(userRepository.findByUsername(userCredentials.getUsername()).getId());
////        UserCredentials newuser=credentials.get();
////        newuser.setPassword(userCredentials.getPassword());
////        newuser.setName(userCredentials.getName());
//////        newuser.setId(user_id);
////        return userRepository.save(newuser);
////    }
//    public UserCredentials updateUserCredentials(long id , UserCredentials userCredentials){
//        UserCredentials credentials = userRepository.findById(id);
//        credentials.setPassword(userCredentials.getPassword());
//        return userRepository.save(credentials);
//    }
//
//}


package com.example.conVRsationalAI.Services;

import com.example.conVRsationalAI.Entity.UserCredentials;
import com.example.conVRsationalAI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

    public String forgotPassword(String username) {

        Optional<UserCredentials> userOptional = Optional
                .ofNullable(userRepository.findByUsername(username));

        if (!userOptional.isPresent()) {
            return "Invalid email id.";
        }

        UserCredentials user = userOptional.get();
        user.setToken(generateToken());
        user.setTokenCreationDate(LocalDateTime.now());

        user = userRepository.save(user);

        return user.getToken();
    }

    private String generateToken() {
        StringBuilder token = new StringBuilder();

        return token.append(UUID.randomUUID().toString())
                .append(UUID.randomUUID().toString()).toString();
    }

    public String resetPassword(String token, String password) {

        Optional<UserCredentials> userOptional = Optional
                .ofNullable(userRepository.findByToken(token));

        if (!userOptional.isPresent()) {
            return "Invalid token.";
        }

        LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();

        if (isTokenExpired(tokenCreationDate)) {
            return "Token expired.";

        }

        UserCredentials user = userOptional.get();

        user.setPassword(password);
        user.setToken(null);
        user.setTokenCreationDate(null);

        userRepository.save(user);

        return "Your password successfully updated.";
    }

    private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {

        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(tokenCreationDate, now);

        return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }


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

    //    public UserCredentials updateUserCredentials(UserCredentials userCredentials){
//        Optional<UserCredentials> credentials=userRepository.findById(userRepository.findByUsername(userCredentials.getUsername()).getId());
//        if(credentials.isEmpty()){
//            return new UserCredentials();
//        }
////        long user_id = userCredentials.getId();
//        userRepository.deleteById(userRepository.findByUsername(userCredentials.getUsername()).getId());
//        UserCredentials newuser=credentials.get();
//        newuser.setPassword(userCredentials.getPassword());
//        newuser.setName(userCredentials.getName());
////        newuser.setId(user_id);
//        return userRepository.save(newuser);
//    }
    public UserCredentials updateUserCredentials(long id , UserCredentials userCredentials){
        UserCredentials credentials = userRepository.findById(id);
        credentials.setPassword(userCredentials.getPassword());
        return userRepository.save(credentials);
    }

}
