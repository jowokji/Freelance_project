package com.example.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;


    @Cacheable("users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        user.setId(UUID.randomUUID());
        userRepository.save(user);
        return user;
    }
}
