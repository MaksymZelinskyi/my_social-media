package com.javadevmz.my_social_media.service.converter;

import com.javadevmz.my_social_media.dao.dto.PostDto;
import com.javadevmz.my_social_media.dao.entity.Post;
import com.javadevmz.my_social_media.dao.entity.User;
import com.javadevmz.my_social_media.dao.repository.LikeRepository;
import com.javadevmz.my_social_media.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class PostPostDtoConverter {

    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private UserManager userManager;

    public PostDto convert(Post post) {
        User currentUser = userManager.getCurrentUser();
        boolean isLiked = likeRepository.isLikedByUser(post, currentUser);
        Long likeCount = likeRepository.countByEntry_Id(post.getId());
        return new PostDto(post, isLiked, likeCount);
    }
}
