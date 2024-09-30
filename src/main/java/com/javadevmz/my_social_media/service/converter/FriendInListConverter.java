package com.javadevmz.my_social_media.service.converter;

import com.javadevmz.my_social_media.dao.dto.FriendInListDto;
import com.javadevmz.my_social_media.dao.entity.User;
import com.javadevmz.my_social_media.dao.entity.UserSubscription;
import com.javadevmz.my_social_media.dao.repository.UserSubscriptionRepository;
import com.javadevmz.my_social_media.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FriendInListConverter {

    @Autowired
    private UserSubscriptionRepository userSubscriptionRepository;
    @Autowired
    private UserManager userManager;

    public FriendInListDto getFollowerInList(UserSubscription us){
        Boolean subscribed = userSubscriptionRepository.isCurrentUserSubscribed(
                userManager.getCurrentUser().getId(), us.getFollower().getId()
        );
        User user = us.getFollower();
        return new FriendInListDto(user.getId(), user.getUsername(), user.getProfilePicture(), us.getSubscriptionTime(), subscribed);
    }

    public FriendInListDto getSubscriptionInList(UserSubscription us){
        User currentUser = userManager.getCurrentUser();
        Boolean subscribed;
        if(currentUser.equals(us.getFollower())){
            subscribed = true;
        }else {
            subscribed = userSubscriptionRepository.isCurrentUserSubscribed(
                    userManager.getCurrentUser().getId(), us.getFollower().getId()
            );
        }
        User user = us.getSubscription();
        return new FriendInListDto(user.getId(), user.getUsername(), user.getProfilePicture(), us.getSubscriptionTime(), subscribed);

    }

}
