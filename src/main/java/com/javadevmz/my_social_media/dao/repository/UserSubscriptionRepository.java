package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.entity.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, UserSubscription.Id> {

}
