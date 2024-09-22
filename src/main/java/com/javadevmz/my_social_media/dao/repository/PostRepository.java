package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.entity.Comment;
import com.javadevmz.my_social_media.dao.entity.Post;
import com.javadevmz.my_social_media.dao.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByAuthorId(Long authorId, Pageable pageable);

    List<Post> findAllByAuthorIsIn(List<User> subscriptions, Pageable pageable);

    @Query("select p" +
            " from Post p" +
            " join UserSubscription us on p.author = us.subscription" +
            " where us.follower = :user")
    List<Post> findPostsOfFriends(User user, Pageable pageable);

    @Query("select p" +
            " from Post p" +
            " join UserSubscription us on p.author = us.subscription" +
            " join PostView pv on p = pv.post" +
            " where us.follower = :user" +
            "  and not pv.user = :user")
    List<Post> findUnseenPostsOfFriends(User user, Pageable pageable);

    @Query("select p" +
            " from Post p" +
            " join Like l on p = l.entry" +
            " group by p" +
            " order by count(l) desc")
    List<Post> findMostPopularPosts(Pageable pageable);

    @Query("select p" +
            " from Post p" +
            " join Like l on p = l.entry" +
            " join PostView pv on pv.post = p" +
            " where not pv.user = :user" +
            " group by p" +
            " order by count(l) desc")
    List<Post> findMostPopularUnseenPosts(User user, Pageable pageable);

    @Query("select p from Post p where p.author.id = :authorId and p.publishedTime < :publishedTime order by p.publishedTime desc limit :count")
    List<Post> findAllByAuthorIdAndPublishedTimeBefore(Long authorId, LocalDateTime publishedTime, int count);

}
