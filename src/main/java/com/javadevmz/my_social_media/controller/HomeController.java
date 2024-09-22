package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.dto.AuthenticationRequest;
import com.javadevmz.my_social_media.dao.entity.Post;
import com.javadevmz.my_social_media.dao.entity.User;
import com.javadevmz.my_social_media.service.PostManager;
import com.javadevmz.my_social_media.service.UserManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class HomeController {

    @Autowired
    private Logger logger;
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
        List<Post> posts = postManager.get25MostPopularPosts();
        postManager.markPostsAsSeen(posts);
        return posts;
    }

    @PostMapping("/login")
    public void login(AuthenticationRequest authenticationRequest){

    }

    @PostMapping("/sign-up")
    public void  register(@Valid @RequestBody User user){
        logger.info(user.getUsername() + " is being registered");
        userManager.addUser(user);
        logger.info(user.getUsername() + " has been registered");
    }
}
