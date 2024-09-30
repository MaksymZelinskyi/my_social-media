package com.javadevmz.my_social_media.dao.dto;

import com.javadevmz.my_social_media.dao.entity.Attachment;

public record UserInListDto(Long id, String username, Attachment profilePicture) {


}
