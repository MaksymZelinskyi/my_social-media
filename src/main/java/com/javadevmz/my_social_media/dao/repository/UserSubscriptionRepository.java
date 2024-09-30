package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.entity.UserSubscription;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, UserSubscription.Id> {

    /*
     The current user will be selected many times which is redundant, but this approach simplifies a lot the process of generating
     the FriendInList DTO, because the subscriptionTime is included.
     Additionally, great chances are that the repeated object will be taken from the cache
     */
    @Query("select us" +
            " from UserSubscription us where us.follower.id=:userId and us.subscriptionTime < :previousSubscriptionTime" +
            " order by us.subscriptionTime desc")
    List<UserSubscription> findUserSubscriptions(Long userId, LocalDateTime previousSubscriptionTime, Pageable pageable);

    @Query("select us" +
            " from UserSubscription us where us.subscription.id=:userId and us.subscriptionTime < :previousSubscriptionTime" +
            " order by us.subscriptionTime desc")
    List<UserSubscription> findUserFollowers(Long userId, LocalDateTime previousSubscriptionTime, Pageable pageable);

    @Query("select count(*) from UserSubscription us where us.subscription.id = :userId")
    long countUserFollowers(Long userId);

    @Query("select count(*) from UserSubscription us where us.follower.id = :userId")
    long countUserSubscriptions(Long userId);

    @Query("select count(*)>0 from UserSubscription us where us.follower.id = :currentUserId and us.subscription.id = :userId")
    Boolean isCurrentUserSubscribed(Long currentUserId, Long userId);
}
