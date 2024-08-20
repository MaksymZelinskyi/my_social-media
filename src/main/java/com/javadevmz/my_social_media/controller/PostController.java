package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.Post;
import com.javadevmz.my_social_media.service.CommentManager;
import com.javadevmz.my_social_media.service.PostEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/posts")
@Transactional
public class PostController {

    @Autowired
    PostEntityManager postEntityManager;
    @Autowired
    private CommentManager commentManager;

    @PostMapping("/posts")
    public Post postPost(@RequestBody Post post) {
        postEntityManager.savePost(post);
        return post;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
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
