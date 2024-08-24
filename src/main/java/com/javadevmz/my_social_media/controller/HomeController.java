package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.entity.Post;
import com.javadevmz.my_social_media.dao.entity.User;
import com.javadevmz.my_social_media.service.PostManager;
import com.javadevmz.my_social_media.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private PostManager postManager;
    @Autowired
    private UserManager userManager;

    @GetMapping("/following")
    public List<Post> getPostsOfFollowing(){
        return postManager.get20PostsOfFriends();
    }

    @GetMapping("/popular")
    public List<Post> getPopularPosts(){
        return postManager.get25MostPopularPosts();
    }

    @GetMapping("/login")
    public void login(){

    }

    @PostMapping("/sign-up")
    public void register(@RequestBody User user){
        userManager.addUser(user);
    }
}
