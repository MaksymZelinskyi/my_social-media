package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Entry, Long> {

}
