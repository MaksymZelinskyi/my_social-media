package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findAllByCommented_Id(Long commentedId, Pageable pageable);

    @Query("select c from Comment c where c.commented.id = :commentedId and c.publishedTime < :publishedTime order by c.publishedTime desc limit :count")
    List<Comment> findAllByCommented_IdAndPublishedTimeBefore(Long commentedId, LocalDateTime publishedTime, int count);

    Comment save(Comment comment);

    @Query("select count(c) from Comment c where c.commented.id = :id")
    public Long findCountByMedia_Id(Long id);
}
