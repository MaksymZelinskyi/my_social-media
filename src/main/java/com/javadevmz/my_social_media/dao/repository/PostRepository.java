package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.Post;
import com.javadevmz.my_social_media.dao.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByAuthorId(Long authorId, Pageable pageable);

    List<Post> findAllByAuthorIsIn(List<User> subscriptions, Pageable pageable);

}
