package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.entity.Comment;
import com.javadevmz.my_social_media.dao.repository.CommentRepository;
import com.javadevmz.my_social_media.service.paging.CommentPagingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommentManager{

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentPagingManager pagingManager;
    @Autowired
    private ContentManager contentManager;
    @Autowired
    private UserManager userManager;

    public List<Comment> getNext20EntryComments(Long entryId, LocalDateTime lastCommentTime){
        return commentRepository.findAllByCommented_IdAndPublishedTimeBefore(entryId, lastCommentTime, 20);
    }

   /* public List<Comment> getFirst20EntryComments(Long entryId){
        pagingManager.refresh(entryId);
        return getNext20EntryComments(entryId);
    }*/

    public Comment getById(Long id) {
        return commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Comment not found"));
    }

    public Comment add(Long commentedId, Comment postComment) {
        postComment.setPublishedTime(LocalDateTime.now());
        postComment.setLastEdit(LocalDateTime.now());
        postComment.setCommented(contentManager.getById(commentedId));
        return commentRepository.save(postComment);
    }

    public Comment update(Long id, Comment comment){
        Comment oldComment = commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Comment not found"));
        oldComment.setText(comment.getText());
        oldComment.setLastEdit(LocalDateTime.now());
        oldComment.setAuthor(userManager.getCurrentUser());
        return oldComment;
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
