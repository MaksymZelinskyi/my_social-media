package com.javadevmz.my_social_media.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserSubscription extends BaseEntity<UserSubscription.Id>{

    @EmbeddedId
    Id id;

    @MapsId
    @ManyToOne
    private User follower;
    @MapsId
    @ManyToOne
    private User subscription;

    private LocalDateTime subscriptionTime = LocalDateTime.now();

    public UserSubscription(User follower, User subscription) {
        this.follower = follower;
        this.subscription = subscription;
    }

    @Data
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Id implements Serializable {
        private Long followerId;
        private Long subscriptionId;
    }
}
