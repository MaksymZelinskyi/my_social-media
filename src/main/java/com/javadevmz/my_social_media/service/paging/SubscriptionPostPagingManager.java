package com.javadevmz.my_social_media.service.paging;

import com.javadevmz.my_social_media.dao.entity.Post;
import com.javadevmz.my_social_media.dao.entity.User;
import com.javadevmz.my_social_media.dao.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Deprecated
@Service
public class SubscriptionPostPagingManager extends PagingManager<Post, User>{

    @Autowired
    PostRepository postRepository;
    
    @Override
    public List<Post> getNextXByCriteria(User user, int x, Sort sort) {
        Map<User, Pageable> pageableMap = getPageableMap();
        pageableMap.putIfAbsent(user, PageRequest.ofSize(x).withSort(sort));
        Pageable pageable = pageableMap.get(user);
        List<Post> newPosts = postRepository.findAllByAuthorIsIn(user.getSubscriptions()
                        .stream()
                        .map(y -> y.getSubscription())
                        .toList()
                ,pageable);
        return postFetch(user, newPosts, x);
    }
}
