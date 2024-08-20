package com.javadevmz.my_social_media.service.paging;

import com.javadevmz.my_social_media.dao.Post;
import com.javadevmz.my_social_media.dao.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserPostPagingManager extends PagingManager<Post, Long> {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getNextXByCriteria(Long authorId, int x, Sort sort){
        Map<Long, Pageable> pageableMap = getPageableMap();
        pageableMap.putIfAbsent(authorId, PageRequest.ofSize(x).withSort(sort));
        Pageable pageable = pageableMap.get(authorId);
        List<Post> newPosts = postRepository.findAllByAuthorId(authorId, pageable);
        return postFetch(authorId, newPosts, x);
    }
}
