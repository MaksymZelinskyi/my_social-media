package com.javadevmz.my_social_media.dao;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Media extends BaseEntity<Long>{

    private String content;

    @ManyToOne
    private User author;

    private LocalDateTime publishedTime;

    @OneToMany(mappedBy = "media")
    List<Like> likes = new ArrayList<>();

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " content=" + content + ", author=" + author.getEmail() + ", publishedTime=" + publishedTime;
    }
}
