package com.javadevmz.my_social_media.service.paging;

import com.javadevmz.my_social_media.dao.entity.Comment;
import com.javadevmz.my_social_media.dao.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Deprecated
@Service
public class CommentPagingManager extends PagingManager<Comment, Long> {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getNextXByCriteria(Long commentedId, int x, Sort sort){
        Map<Long, Pageable> pageableMap = getPageableMap();
        pageableMap.putIfAbsent(commentedId, PageRequest.ofSize(x).withSort(sort));
        Pageable pageable = pageableMap.get(commentedId);
        Page<Comment> newComments = commentRepository.findAllByCommented_Id(commentedId, pageable);
        System.out.println(pageable.getPageNumber());
        return postFetch(commentedId, newComments.getContent(), x);
    }
}
