package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.Comment;
import com.javadevmz.my_social_media.dao.repository.CommentRepository;
import com.javadevmz.my_social_media.service.paging.CommentPagingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CommentManager{

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentPagingManager pagingManager;
    @Autowired
    private MediaManager mediaManager;
    @Autowired
    private UserManager userManager;

    public List<Comment> getNext20MediaComments(Long mediaId, LocalDateTime lastCommentTime){
        return commentRepository.findAllByCommented_IdAndPublishedTimeBefore(mediaId, lastCommentTime, 20);
    }

   /* public List<Comment> getFirst20MediaComments(Long mediaId){
        pagingManager.refresh(mediaId);
        return getNext20MediaComments(mediaId);
    }*/

    public Comment getById(Long id) {
        return commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Comment not found"));
    }

    public Comment add(Long commentedId, Comment postComment) {
        postComment.setPublishedTime(LocalDateTime.now());
        postComment.setLastEdit(LocalDateTime.now());
        postComment.setCommented(mediaManager.getById(commentedId));
        return commentRepository.save(postComment);
    }

    public Comment update(Long id, Comment comment){
        Comment oldComment = commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Comment not found"));
        oldComment.setContent(comment.getContent());
        oldComment.setLastEdit(LocalDateTime.now());
        oldComment.setAuthor(userManager.getCurrentUser());
        return oldComment;
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
