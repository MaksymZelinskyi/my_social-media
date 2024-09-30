package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.dto.UserInListDto;
import com.javadevmz.my_social_media.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("select u from User u where u.username like :pattern")
    List<User> findUsersByUsernameLike(String pattern);
}
