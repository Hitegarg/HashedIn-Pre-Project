package com.example.conVRsationalAI.Controller;

import com.example.conVRsationalAI.Entity.UserCredentials;
import com.example.conVRsationalAI.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/credentials")
    public UserCredentials insertCredentials(@RequestBody UserCredentials credentials) {
//        credentials.setProfile(new Profile());
//        credentials.setRole("GENERAL");
        return userService.insertUserCredentials(credentials);
    }

    @GetMapping("/credentials")
    public List<UserCredentials> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/credentials/{username}")
    public void deleteCredentials(@PathVariable(value = "username") String username) {
        userService.deleteCredentials(username);
    }
    @GetMapping("/credentials/{username}")
    public UserCredentials getUser(@PathVariable(value = "username") String username){
        return userService.getUser(username);
    }

    @GetMapping("/contactUs")
    public String contactUs(){
        return "Contact Us page";
    }
    @GetMapping("/dashboard")
    public String faq(){
        return "This is Dashboard page which is only visible for authenticated users";
    }

//
@PutMapping("/credentials")
public UserCredentials updateCredentials(@RequestBody UserCredentials userCredentials){
    return userService.updateUserCredentials(userCredentials);
}

}
