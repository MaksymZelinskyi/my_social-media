package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.entity.PostView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostViewRepository extends JpaRepository<PostView, Long> {

    @Query(nativeQuery = true, value = "insert into post_view(user_id, post_id) values (:userId, :postId)")
    void insertPostView(@Param("userId") Long userId, @Param("postId") Long postId);
}
