package com.example.intregradorapi.controller;

import com.example.intregradorapi.entity.User;
import com.example.intregradorapi.repository.UserRepository;
import com.example.intregradorapi.util.JwtUtil;
import com.example.intregradorapi.util.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("users/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        var hashedPass = PasswordHasher.hashPassword(user.getPassword());
        user.setPassword(hashedPass);
        userRepository.save(user);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("users/list")
    public ResponseEntity<?> listUsers(@RequestHeader("Authorization") String authorization) {
        if(authorization.startsWith("Bearer ")){
            var token = authorization.substring(7);
            try {
                JwtUtil.validateToken(token);
                var users = userRepository.findAll();
                return ResponseEntity.status(200).body(users);
            }catch (Exception ex){
                ex.printStackTrace();
                return ResponseEntity.status(401).body(ex.getMessage());
            }
        }else{
            return ResponseEntity.status(401).body(Map.of("message", "Invalid Authorization"));
        }

    }

    //users?email=domic.rincon@gmail.com -> Request
    //users/domic.rincon@gmail.com -> Path Variable
    @GetMapping("users")
    public ResponseEntity<?> getUserByEmail(@RequestParam("email") String email){
        Optional<User> optuser = userRepository.findUserByEmail(email);
        if(optuser.isPresent()){
            var user = optuser.get();
            return ResponseEntity.status(200).body(user);
        }else{
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @PostMapping("users/login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        var hashedPass = PasswordHasher.hashPassword(user.getPassword());
        var optionalUser = userRepository.findUserByEmailAndPassword(user.getEmail(), hashedPass);
        if(optionalUser.isPresent()){
            var token = JwtUtil.generateToken(user.getEmail());
            return ResponseEntity.status(200).body(Map.of(
                    "access_token",token
            ));
        }else{
            return ResponseEntity.status(404).body(Map.of(
                    "message","El usuario con ese email o password no existe"
            ));
        }
    }



    //users/list
    //users/delete
    //users/login

}
