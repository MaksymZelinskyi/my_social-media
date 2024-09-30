package com.javadevmz.my_social_media.dao.dto;

import com.javadevmz.my_social_media.dao.entity.Attachment;
import com.javadevmz.my_social_media.dao.entity.Post;

public record PostDto(Post post, Boolean liked, Long likeCount) {
}
