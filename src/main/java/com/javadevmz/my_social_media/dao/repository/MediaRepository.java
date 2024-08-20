package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {

}
