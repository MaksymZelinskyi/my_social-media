package com.javadevmz.my_social_media.service.paging;

import com.javadevmz.my_social_media.dao.entity.Like;
import com.javadevmz.my_social_media.dao.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Deprecated
@Service
public class LikePagingManager extends PagingManager<Like, Long> {

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public List<Like> getNextXByCriteria(Long likedId, int x, Sort sort){
        Map<Long, Pageable> pageableMap = getPageableMap();
        pageableMap.putIfAbsent(likedId, PageRequest.ofSize(x).withSort(sort));
        Pageable pageable = pageableMap.get(likedId);
        List<Like> newLikes = likeRepository.findAllByEntry_Id(likedId, pageable);
        return postFetch(likedId, newLikes, x);
    }
}
