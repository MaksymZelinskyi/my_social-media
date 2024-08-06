package com.javadevmz.my_social_media.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserSubscription extends BaseEntity<Long>{

    @ManyToOne
    private User follower;
    @ManyToOne
    private User followed;
}
