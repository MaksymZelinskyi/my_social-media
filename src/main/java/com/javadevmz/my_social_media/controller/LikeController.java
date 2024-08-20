package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.Like;
import com.javadevmz.my_social_media.service.LikeManager;
import com.javadevmz.my_social_media.service.MediaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LikeController {

    @Autowired
    private LikeManager likeManager;
    @Autowired
    private MediaManager mediaManager;

    @GetMapping("/posts/{postId}/likes")
    public List<Like> getPostLikes(@PathVariable Long postId,
                                   @RequestParam(required = false) Boolean scrolled)
    {
       if(scrolled){
           return likeManager.getNext30MediaLikes(postId);
       }
        return likeManager.getNext30MediaLikes(postId);
    }

    @GetMapping("/posts/{postId}/likes/count")
    public Long getPostLikeCount(@PathVariable Long postId){
        return likeManager.getLikeCountByMediaId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{commentId}likes/count")
    public Long getCommentLikeCount(@PathVariable Long commentId){
        return likeManager.getLikeCountByMediaId(commentId);
    }
}
