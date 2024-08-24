package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.entity.Entry;
import com.javadevmz.my_social_media.dao.entity.Like;
import com.javadevmz.my_social_media.dao.repository.LikeRepository;
import com.javadevmz.my_social_media.dao.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LikeManager {

    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private UserManager userManager;

  /* public List<Like> getNext30EntryLikes(Long entryId){
      Sort sort = Sort.by(Sort.Direction.DESC, "time");
      return pagingManager.getNextXByCriteria(entryId, 30, sort);
   }

   public List<Like> getFirst30EntryLikes(Long entryId){
      pagingManager.refresh(entryId);
      return getNext30EntryLikes(entryId);
   }*/

   public List<Like> getNext30EntryLikes(Long entryId, LocalDateTime lastLikeTime){
      return likeRepository.findAllByEntry_IdAndTimeBefore(entryId, lastLikeTime, 30);
   }

   public Long getLikeCountByMediaId(Long mediaId) {
      return likeRepository.findCountByEntry_Id(mediaId);
   }

   public void addLike(Long contentId){
      Entry entry = contentRepository.findById(contentId).orElseThrow(()->new NoSuchElementException("Entry not found"));
      likeRepository.save(new Like(userManager.getCurrentUser(), entry));
   }

   public void deleteLike(Long contentItemId){
       likeRepository.deleteById(new Like.Id(userManager.getCurrentUser().getId(), contentItemId));
   }
}
