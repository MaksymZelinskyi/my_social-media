package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.Post;
import com.javadevmz.my_social_media.dao.repository.PostRepository;
import com.javadevmz.my_social_media.service.paging.SubscriptionPostPagingManager;
import com.javadevmz.my_social_media.service.paging.UserPostPagingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DependsOn("userManager")
public class PostManager{

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserManager userManager;
    @Autowired
    private UserPostPagingManager userPostPagingManager;
    @Autowired
    private SubscriptionPostPagingManager subscriptionPostPagingManager;

    public List<Post> getNext20UserPosts(Long userId){
        Sort sort = Sort.by(Sort.Direction.DESC, "publishedTime");
        return userPostPagingManager.getNextXByCriteria(userId, 20, sort);
    }

    public List<Post> getFirst20UserPosts(Long userId){
        userPostPagingManager.refresh(userManager.getCurrentUser().getId());
        return getNext20UserPosts(userId);
    }

    public List<Post> getNext20UserSubscriptionsPosts(){
        Sort sort = Sort.by(Sort.Direction.DESC, "published");
        return subscriptionPostPagingManager.getNextXByCriteria(userManager.getCurrentUser(), 20, sort);
    }

    public List<Post> getFirst20UserSubscriptionsPosts(){
        subscriptionPostPagingManager.refresh(userManager.getCurrentUser());
        return getNext20UserSubscriptionsPosts();
    }

}
