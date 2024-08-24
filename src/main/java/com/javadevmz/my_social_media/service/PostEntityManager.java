package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.entity.Post;
import com.javadevmz.my_social_media.dao.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostEntityManager {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post getPostById(Long id){
        return postRepository.findById(id).orElseThrow(()-> new RuntimeException("Post not found"));
    }

    public void savePost(Post post){
        postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public Post updatePost(Long id, Post post){
        Post oldPost = getPostById(id);
        oldPost.setTitle(post.getTitle());
        oldPost.setText(post.getText());
        return oldPost;
    }
}
