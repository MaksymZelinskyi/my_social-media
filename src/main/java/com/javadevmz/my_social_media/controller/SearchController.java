package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.dto.FriendInListDto;
import com.javadevmz.my_social_media.dao.dto.PostDto;
import com.javadevmz.my_social_media.dao.dto.UserInListDto;
import com.javadevmz.my_social_media.dao.entity.Post;
import com.javadevmz.my_social_media.service.SearchManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchManager searchManager;

    @PostMapping("/search/users")
    public List<UserInListDto> searchUsers(@RequestBody String query) {
        return searchManager.findMatchingUsers(query);
    }

    @PostMapping("/search/posts")
    public List<PostDto> searchPosts(@RequestBody String query) {
        return searchManager.findMatchingPosts(query);
    }
}
