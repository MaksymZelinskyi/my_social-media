package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.dto.UserDto;
import com.javadevmz.my_social_media.dao.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("select new com.javadevmz.my_social_media.dao.dto.UserDto(us.subscription.id, us.subscription.username, us.subscription.profilePicture)" +
            " from UserSubscription us where us.follower.id=:userId and us.subscriptionTime < :previousSubscriptionTime" +
            " order by us.subscriptionTime desc")
    List<UserDto> findUserSubscriptions(Long userId, LocalDateTime previousSubscriptionTime, Pageable pageable);

    @Query("select count(*) from UserSubscription us where us.subscription.id = :userId")
    long countUserFollowers(Long userId);

    @Query("select count(*) from UserSubscription us where us.follower.id = :userId")
    long countUserSubscriptions(Long userId);

    @Query("select new com.javadevmz.my_social_media.dao.dto.UserDto(u.id, u.username, u.profilePicture) from User u where u.username like :pattern")
    List<UserDto> findUsersByUsernameLike(String pattern);
}
