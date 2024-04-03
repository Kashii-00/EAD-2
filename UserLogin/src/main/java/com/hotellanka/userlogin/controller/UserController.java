package com.hotellanka.userlogin.controller;

import com.hotellanka.userlogin.model.UserEntity;
import com.hotellanka.userlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserEntity user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserEntity user) {
        if (userService.authenticateUser(user.getUsername(), user.getPassword())) {
            return ResponseEntity.ok("Login successful.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserEntity> getUserByUsername(@PathVariable String username) {
        UserEntity user = userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else
        {
            return ResponseEntity.notFound().build();
        }
    }

}
