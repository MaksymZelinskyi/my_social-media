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

    @Query("select new com.javadevmz.my_social_media.dao.dto.UserDto(us.subscription.username, us.subscription.profilePicture)" +
            " from UserSubscription us where us.follower.id=:userId and us.subscriptionTime < :previousSubscriptionTime" +
            " order by us.subscriptionTime desc")
    List<UserDto> findUserSubscriptions(Long userId, LocalDateTime previousSubscriptionTime, Pageable pageable);

}
