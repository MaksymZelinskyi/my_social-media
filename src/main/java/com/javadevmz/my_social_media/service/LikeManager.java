package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.Like;
import com.javadevmz.my_social_media.dao.repository.LikeRepository;
import com.javadevmz.my_social_media.service.paging.LikePagingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeManager {

   @Autowired
   private LikeRepository likeRepository;
   @Autowired
   private LikePagingManager pagingManager;

   public List<Like> getNext30MediaLikes(Long mediaId){
      Sort sort = Sort.by(Sort.Direction.DESC, "time");
      return pagingManager.getNextXByCriteria(mediaId, 30, sort);
   }

   public List<Like> getFirst30MediaLikes(Long mediaId){
      pagingManager.refresh(mediaId);
      return getNext30MediaLikes(mediaId);
   }

   public Long getLikeCountByMediaId(Long mediaId) {
     return likeRepository.findCountByMedia_Id(mediaId);
   }
}
