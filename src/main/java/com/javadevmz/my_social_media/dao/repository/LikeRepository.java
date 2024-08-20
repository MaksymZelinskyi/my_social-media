package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.Comment;
import com.javadevmz.my_social_media.dao.Like;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    public List<Like> findAllByMedia_Id(Long mediaId, Pageable pageable);

    @Query("select l from Like l where l.media.id = :mediaId and l.time < :previousTime order by l.time desc limit :count")
    List<Like> findAllByMedia_IdAndTimeBefore(Long mediaId, LocalDateTime previousTime, int count);

    @Query("select count(l) from Like l where l.media.id = :id")
    public Long findCountByMedia_Id(Long id);
}
