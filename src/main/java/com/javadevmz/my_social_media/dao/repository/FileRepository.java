package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<Attachment, Long> {

}
