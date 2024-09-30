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

   @PostMapping({"/posts/{commented_id}/comments","/posts/{postId}/comments/{commented_id}/responses"})
   public Comment addComment(@PathVariable("commented_id") Long commentedId, @RequestBody Comment comment) {
        return commentManager.add(commentedId, comment);
   }

    @PutMapping({"/posts/{commented_Id}/comments/{id}", "/posts/{postId}/comments/{commented_id}/responses/{id}"})
    public Comment updateComment(@PathVariable("commented_id") Long id, @RequestBody Comment comment) {
        return commentManager.update(id, comment);
   }

    @DeleteMapping({"/posts/{commented_Id}/comments/{id}", "/posts/{postId}/comments/{commented_id}/responses/{id}"})
    public void deletePostComment(@PathVariable("id") Long id) {
        commentManager.deleteById(id);
   }
}
