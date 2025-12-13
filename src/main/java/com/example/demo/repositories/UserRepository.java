package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User, String> {
    Optional<User> getUsersByUsernameAndPassword(String username, String password);
}
