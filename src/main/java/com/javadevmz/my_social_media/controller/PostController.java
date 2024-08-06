package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.Post;
import com.javadevmz.my_social_media.dao.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class PostController {

    @Autowired
    PostRepository postRepository;

    @PostMapping("/posts")
    public Post post(@RequestBody Post post) {
        postRepository.save(post);
        post.equals(new Object());
        return post;
    }
}
