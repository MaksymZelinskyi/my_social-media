package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.entity.Post;
import com.javadevmz.my_social_media.dao.entity.PostView;
import com.javadevmz.my_social_media.dao.repository.PostRepository;
import com.javadevmz.my_social_media.dao.repository.PostViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@DependsOn("userManager")
public class PostManager{

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserManager userManager;
    @Autowired
    private PostViewRepository postViewRepository;

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

    public void markPostAsSeen(Post post){
        markPostsAsSeen(Collections.singletonList(post));
    }

    public void markPostsAsSeen(List<Post> posts) {
        postViewRepository.saveAll(posts.stream()
                .map(x -> new PostView(x, userManager.getCurrentUser())
                )
                .collect(Collectors.toList()));
    }

    public List<Post> get20PostsByUserId(long userId, LocalDateTime lastSeenTime){
        return postRepository.findAllByAuthorIdAndPublishedTimeBefore(userId,  lastSeenTime, 20);
    }
}
