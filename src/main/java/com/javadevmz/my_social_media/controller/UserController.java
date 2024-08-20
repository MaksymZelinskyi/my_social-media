package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.User;
import com.javadevmz.my_social_media.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/users")
public class UserController {

    @Autowired
    private UserManager userManager;

    @PostMapping("/users")
    public void register(@RequestBody User user) {
        userManager.addUser(user);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userManager.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userManager.deleteUser(id);
    }
}
