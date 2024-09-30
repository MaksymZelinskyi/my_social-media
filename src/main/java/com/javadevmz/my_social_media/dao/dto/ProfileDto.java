package com.javadevmz.my_social_media.dao.dto;

import com.javadevmz.my_social_media.dao.entity.Attachment;
import com.javadevmz.my_social_media.dao.entity.User;

import java.time.LocalDateTime;

public record ProfileDto(Long id, String username, Attachment profilePicture, Boolean subscribed, Long followersCount, Long subscriptionsCount) {
}
