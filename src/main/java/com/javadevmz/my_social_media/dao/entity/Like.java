package com.javadevmz.my_social_media.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name="likes")
public class Like extends BaseEntity<Like.Id> {

    @EmbeddedId
    private Id id;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("entryId")
    private Entry entry;

    private LocalDateTime time = LocalDateTime.now();

    public Like(User user, Entry entry) {
        this.user = user;
        this.entry = entry;
    }

    @Data
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Id implements Serializable {
        private Long userId;
        private Long entryId;
    }
}
