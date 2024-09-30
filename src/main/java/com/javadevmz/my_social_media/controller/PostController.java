package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.dto.PostDto;
import com.javadevmz.my_social_media.dao.entity.Post;
import com.javadevmz.my_social_media.service.CommentManager;
import com.javadevmz.my_social_media.service.PostEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController("/posts")
public class PostController {

    @Autowired
    PostEntityManager postEntityManager;
    @Autowired
    private CommentManager commentManager;
    @Autowired
    private Logger logger;

    @PostMapping("/posts")
    public Post postPost(@RequestBody Post post) {
        logger.info("Post created: " + post);
        postEntityManager.savePost(post);
        return post;
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPosts() {
        return postEntityManager.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable Long id) {
       return postEntityManager.getPostById(id);
    }

    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postEntityManager.updatePost(id, post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        postEntityManager.deletePost(id);
    }

}
