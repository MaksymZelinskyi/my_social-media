package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.entity.Comment;
import com.javadevmz.my_social_media.service.CommentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentManager commentManager;

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getPostComments(@PathVariable Long postId, @RequestParam(required = false) LocalDateTime lastCommentTime) {
        if(lastCommentTime == null){
            lastCommentTime = LocalDateTime.now();
        }
        return commentManager.getNext20EntryComments(postId, lastCommentTime);
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public Comment getPostComment(@PathVariable Long postId) {
        return commentManager.getById(postId);
    }

    @PostMapping("/posts/{postId}/comments")
    public Comment addPostComment(@PathVariable Long postId, @RequestBody Comment comment) {
       return commentManager.add(postId, comment);
   }

    @PutMapping("/posts/{postId}/comments/{id}")
    public Comment updatePostComment(@PathVariable("id") Long id, @RequestBody Comment comment) {
        return commentManager.update(id, comment);
   }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public void deletePostComment(@PathVariable("id") Long id) {
        commentManager.deleteById(id);
   }
}
