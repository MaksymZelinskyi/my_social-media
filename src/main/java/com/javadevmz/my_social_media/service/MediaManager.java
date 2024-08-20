package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.Media;
import com.javadevmz.my_social_media.dao.repository.LikeRepository;
import com.javadevmz.my_social_media.dao.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaManager {

    @Autowired
    private MediaRepository mediaRepository;
    @Autowired
    private LikeRepository likeRepository;

    public Media getById(Long id) {
        return mediaRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Media not found"));
    }

}
