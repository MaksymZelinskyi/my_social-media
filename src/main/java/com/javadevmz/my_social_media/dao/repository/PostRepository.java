package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
