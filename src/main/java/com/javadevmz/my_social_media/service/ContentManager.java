package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.entity.Entry;
import com.javadevmz.my_social_media.dao.repository.LikeRepository;
import com.javadevmz.my_social_media.dao.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentManager {

    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private LikeRepository likeRepository;

    public Entry getById(Long id) {
        return contentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Entry not found"));
    }

}
