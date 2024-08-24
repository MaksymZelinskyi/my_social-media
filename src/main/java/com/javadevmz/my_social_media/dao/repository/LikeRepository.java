package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.entity.Like;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Like.Id> {

    List<Like> findAllByEntry_Id(Long mediaId, Pageable pageable);

    @Query("select l from Like l where l.entry.id = :entryId and l.time < :previousTime order by l.time desc limit :count")
    List<Like> findAllByEntry_IdAndTimeBefore(Long entryId, LocalDateTime previousTime, int count);

    @Query("select count(l) from Like l where l.entry.id = :id")
    Long findCountByEntry_Id(Long id);
}
