package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.dto.FriendInListDto;
import com.javadevmz.my_social_media.dao.dto.PostDto;
import com.javadevmz.my_social_media.dao.dto.UserInListDto;
import com.javadevmz.my_social_media.dao.entity.Post;
import com.javadevmz.my_social_media.dao.entity.User;
import com.javadevmz.my_social_media.dao.repository.PostRepository;
import com.javadevmz.my_social_media.dao.repository.UserRepository;
import com.javadevmz.my_social_media.dao.repository.UserSubscriptionRepository;
import com.javadevmz.my_social_media.service.converter.PostPostDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchManager {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserSubscriptionRepository userSubscriptionRepository;
    @Autowired
    private PostPostDtoConverter postPostDtoConverter;

    public List<UserInListDto> findMatchingUsers(String pattern){
        return userRepository.findUsersByUsernameLike(pattern).stream()
                .map(x-> new UserInListDto(x.getId(), x.getUsername(), x.getProfilePicture())
                ).toList();
    }

    public List<PostDto> findMatchingPosts(String pattern){

        List<Post> posts = postRepository.findAllByTitleLike(pattern);
        return posts.stream().map(x -> postPostDtoConverter.convert(x)).toList();
    }
}

