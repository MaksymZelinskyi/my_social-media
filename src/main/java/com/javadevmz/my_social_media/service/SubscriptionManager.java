package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.dto.UserDto;
import com.javadevmz.my_social_media.dao.entity.User;
import com.javadevmz.my_social_media.dao.entity.UserSubscription;
import com.javadevmz.my_social_media.dao.repository.UserRepository;
import com.javadevmz.my_social_media.dao.repository.UserSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubscriptionManager {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserManager userManager;
    @Autowired
    private UserSubscriptionRepository userSubscriptionRepository;

    public List<UserDto> getSubscriptions(Long userId, LocalDateTime previousSubscriptionTime, int count) {
        return userRepository.findUserSubscriptions(userId, previousSubscriptionTime, PageRequest.ofSize(count));
    }

    public List<UserDto> getCurrentUsersubscriptions(LocalDateTime previousSubscriptionTime, int count){
        return getSubscriptions(userManager.getCurrentUser().getId(), previousSubscriptionTime, count);
    }

    public void subscribeTo(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        User currentUser = userManager.getCurrentUser();
        userSubscriptionRepository.save(new UserSubscription(currentUser, user));
    }

    public void unsubscribeOf(Long userId){
        User currentUser = userManager.getCurrentUser();
        userSubscriptionRepository.deleteById(new UserSubscription.Id(currentUser.getId(), userId));
    }
}