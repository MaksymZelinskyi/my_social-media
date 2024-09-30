package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.service.converter.PostPostDtoConverter;
import com.javadevmz.my_social_media.dao.dto.PostDto;
import com.javadevmz.my_social_media.dao.entity.Post;
import com.javadevmz.my_social_media.dao.repository.PostRepository;
import com.javadevmz.my_social_media.dao.repository.PostViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@DependsOn("userManager")
public class PostManager{

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserManager userManager;
    @Autowired
    private PostViewRepository postViewRepository;
    @Autowired
    private PostPostDtoConverter postPostDtoConverter;

    public List<PostDto> get20PostsOfFriends(){
       List<Post> posts = postRepository.findUnseenPostsOfFriends(userManager.getCurrentUser(), PageRequest.of(0, 20, Sort.by("publishedTime").descending()));
       if(posts == null || posts.isEmpty()){
           posts = postRepository.findPostsOfFriends(userManager.getCurrentUser(), PageRequest.of(0, 20, Sort.by("publishedTime").descending()));
       }
        return posts.stream().map(postPostDtoConverter::convert).toList();
    }

    public List<PostDto> get25MostPopularPosts(){
        List<Post> posts = postRepository.findMostPopularUnseenPosts(userManager.getCurrentUser(), PageRequest.ofSize(25));
        if(posts == null || posts.isEmpty()){
            posts = postRepository.findMostPopularPosts(PageRequest.ofSize(25));
        }
        return posts.stream().map(postPostDtoConverter::convert).toList();
    }

    public void markPostAsSeen(PostDto post){
        postViewRepository.insertPostView(userManager.getCurrentUser().getId(), post.post().getId());
    }

    public void markPostsAsSeen(List<PostDto> posts) {
        for(PostDto post : posts){
            markPostAsSeen(post);
        }
    }

    public List<PostDto> get20PostsByUserId(long userId, LocalDateTime lastSeenTime){
        return postRepository.findAllByAuthorIdAndPublishedTimeBefore(userId,  lastSeenTime, 20)
                .stream()
                .map(x -> postPostDtoConverter.convert(x))
                .toList();
    }
}
