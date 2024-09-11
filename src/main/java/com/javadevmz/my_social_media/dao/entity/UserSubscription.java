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
public class UserSubscription implements BaseEntity<UserSubscription.Id> {

    @EmbeddedId
    Id id;

    @MapsId("followerId")
    @ManyToOne
    private User follower;
    @MapsId("subscriptionId")
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
