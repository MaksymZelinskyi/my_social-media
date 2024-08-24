package com.javadevmz.my_social_media.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostView extends BaseEntity<PostView.Id>{

    @EmbeddedId
    private Id id;

    @MapsId
    @ManyToOne
    private Post post;

    @MapsId
    @ManyToOne
    private User user;

    @Data
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Id implements Serializable {
        private long postId;
        private long userId;
    }
}
