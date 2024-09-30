package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.dto.PostDto;
import com.javadevmz.my_social_media.dao.dto.ProfileDto;
import com.javadevmz.my_social_media.dao.entity.Post;
import com.javadevmz.my_social_media.dao.entity.User;
import com.javadevmz.my_social_media.service.PostManager;
import com.javadevmz.my_social_media.service.UserManager;
import com.javadevmz.my_social_media.service.converter.UserProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@RestController("/users")
public class UserController {

    @Autowired
    private UserManager userManager;
    @Autowired
    private Logger logger;
    @Autowired
    private PostManager postManager;
    @Autowired
    private UserProfileConverter userProfileConverter;

    @PostMapping("/users")
    public void register(@RequestBody User user) {
        logger.info(user + " is being registered [controller]");
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

    @GetMapping("/users/{id}")
    public ProfileDto getUser(@PathVariable Long id){
        return userProfileConverter.getProfileDto(userManager.getUserById(id));
    }

    @GetMapping("/users/{id}/posts")
    public List<PostDto> getPosts(@PathVariable("id") Long userId, @RequestParam LocalDateTime lastSeenPTime){
        return postManager.get20PostsByUserId(userId, lastSeenPTime);
    }

    @GetMapping("/users/current")
    public User getCurrent(){
        return userManager.getCurrentUser();
    }
}
