package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByUsernameAndPassword(String username,String password){
        return this.userRepository.getUsersByUsernameAndPassword(username, password);
    }
}
