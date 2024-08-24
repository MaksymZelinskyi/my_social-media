package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.entity.User;
import com.javadevmz.my_social_media.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserManager {

    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user){
        User oldUser = getUserById(id);
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setPersonalInfo(user.getPersonalInfo());
        return oldUser;
    }

    public User getCurrentUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByUsername(username);
    }
}
