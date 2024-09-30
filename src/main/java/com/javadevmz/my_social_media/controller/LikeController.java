package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.entity.Like;
import com.javadevmz.my_social_media.service.LikeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class LikeController {

    @Autowired
    private LikeManager likeManager;

    @GetMapping("/posts/{postId}/likes")
    public List<Like> getPostLikes(@PathVariable Long postId,
                                   @RequestParam(required = false) LocalDateTime oldestLikeTime)
    {
       if(oldestLikeTime ==null){
           oldestLikeTime = LocalDateTime.now();
       }
        return likeManager.getNext30EntryLikes(postId, oldestLikeTime);
    }

    @GetMapping("/posts/{postId}/likes/count")
    public Long getPostLikeCount(@PathVariable Long postId){
        return likeManager.getLikeCountByMediaId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{commentId}/likes/count")
    public Long getCommentLikeCount(@PathVariable Long commentId){
        return likeManager.getLikeCountByMediaId(commentId);
    }

    @PostMapping({"/posts/{likedId}/likes", "/posts/{postId}/comments/{likedId}/likes"})
    public void addLike(@PathVariable Long postId){
        likeManager.addLike(postId);
    }

    @DeleteMapping({"/posts/{likedId}/likes", "/posts/{postId}/comments/{likedId}/likes"})
    public void unlike(@PathVariable Long likedId){
        likeManager.deleteLike(likedId);
    }

}
