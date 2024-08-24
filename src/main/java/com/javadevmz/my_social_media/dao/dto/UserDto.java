package com.javadevmz.my_social_media.dao.dto;

import com.javadevmz.my_social_media.dao.entity.Attachment;

import java.net.URL;

public record UserDto(String username, Attachment profilePicture) {
}
