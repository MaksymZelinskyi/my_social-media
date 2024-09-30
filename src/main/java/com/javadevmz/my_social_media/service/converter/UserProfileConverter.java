package com.javadevmz.my_social_media.service.converter;

import com.javadevmz.my_social_media.dao.dto.ProfileDto;
import com.javadevmz.my_social_media.dao.entity.User;
import com.javadevmz.my_social_media.dao.repository.UserSubscriptionRepository;
import com.javadevmz.my_social_media.service.SubscriptionManager;
import com.javadevmz.my_social_media.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileConverter {

    @Autowired
    private UserSubscriptionRepository userSubscriptionRepository;
    @Autowired
    private UserManager userManager;
    @Autowired
    private SubscriptionManager subscriptionManager;

    public ProfileDto getProfileDto(User user) {
        Boolean subscribed = subscriptionManager.getCurrentUserSubscribed(user);
        Long followersCount = userManager.getFolowersCount(user.getId());
        Long subscriptionsCount = userManager.getSubscriptionsCount(user.getId());
        return new ProfileDto(user.getId(), user.getUsername(), user.getProfilePicture(), subscribed, followersCount, subscriptionsCount);
    }
}
