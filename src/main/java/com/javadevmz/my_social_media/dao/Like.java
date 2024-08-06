package com.javadevmz.my_social_media.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "likes")
public class Like extends BaseEntity<Long> {

    @ManyToOne
    private User user;
    @ManyToOne
    private Media media;

    private LocalDateTime time;

}
