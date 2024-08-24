package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.entity.Post;
import com.javadevmz.my_social_media.dao.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DependsOn("userManager")
public class PostManager{

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserManager userManager;

    public List<Post> get20PostsOfFriends(){
       List<Post> posts = postRepository.findUnseenPostsOfFriends(userManager.getCurrentUser(), PageRequest.of(0, 20, Sort.by("publishedTime").descending()));
       if(posts == null || posts.isEmpty()){
           posts = postRepository.findPostsOfFriends(userManager.getCurrentUser(), PageRequest.of(0, 20, Sort.by("publishedTime").descending()));
       }
       return posts;
    }

    public List<Post> get25MostPopularPosts(){
        List<Post> posts = postRepository.findMostPopularUnseenPosts(userManager.getCurrentUser(), PageRequest.ofSize(25));
        if(posts == null || posts.isEmpty()){
            posts = postRepository.findMostPopularPosts(PageRequest.ofSize(25));
        }
        return posts;
    }
}
