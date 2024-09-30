package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.dto.AuthenticationRequest;
import com.javadevmz.my_social_media.dao.dto.PostDto;
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
    public List<PostDto> getPostsOfFollowing(){
        return postManager.get20PostsOfFriends();
    }

    @GetMapping("/popular")
    public List<PostDto> getPopularPosts(){
        List<PostDto> posts = postManager.get25MostPopularPosts();
        postManager.markPostsAsSeen(posts);
        return posts;
    }

    @PostMapping("/login")
    public Long login(AuthenticationRequest authenticationRequest){
        return userManager.getCurrentUser().getId();
    }

    @PostMapping("/sign-up")
    public Long register(@Valid @RequestBody User user){
        userManager.addUser(user);
        return user.getId();
    }
}
