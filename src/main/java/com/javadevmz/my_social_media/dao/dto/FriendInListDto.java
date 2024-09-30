package com.javadevmz.my_social_media.dao.dto;

import com.javadevmz.my_social_media.dao.entity.Attachment;
import com.javadevmz.my_social_media.dao.entity.User;

import java.time.LocalDateTime;

public record FriendInListDto(Long id, String username, Attachment profilePicture, LocalDateTime subscriptionTime, Boolean subscribed) {

}
