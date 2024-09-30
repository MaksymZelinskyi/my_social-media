package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.dto.FriendInListDto;
import com.javadevmz.my_social_media.dao.dto.ProfileDto;
import com.javadevmz.my_social_media.service.SubscriptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class SubscriptionController {

    @Autowired
    private SubscriptionManager subscriptionManager;

    @GetMapping("/users/{userId}/subscriptions")
    public List<FriendInListDto> getSubscriptions(@PathVariable Long userId,
                                                  @RequestParam(required = false) LocalDateTime previousSubscriptionTime,
                                                  @RequestParam int count) {
        if (previousSubscriptionTime == null) {
            previousSubscriptionTime = LocalDateTime.now();
        }
       return subscriptionManager.getSubscriptions(userId, previousSubscriptionTime, count);
    }

    @GetMapping("/users/{userId}/followers")
    public List<FriendInListDto> getFollowers(@PathVariable Long userId,
                                                  @RequestParam(required = false) LocalDateTime previousSubscriptionTime,
                                                  @RequestParam int count) {
        if (previousSubscriptionTime == null) {
            previousSubscriptionTime = LocalDateTime.now();
        }
        return subscriptionManager.getFollowers(userId, previousSubscriptionTime, count);
    }

    @PostMapping("/subscriptions/{userId}")
    public void subscribe(@PathVariable Long userId){
            subscriptionManager.subscribeTo(userId);
    }

    @DeleteMapping("/subscriptions/{userId}")
    public void unsubscribe(@PathVariable Long userId){
            subscriptionManager.unsubscribeOf(userId);
    }

}
