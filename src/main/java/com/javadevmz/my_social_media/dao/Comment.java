package com.javadevmz.my_social_media.dao;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "replies")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Comment extends Media{

    @ManyToOne
    private Media media;

    @OneToMany(mappedBy = "media", orphanRemoval = true)
    List<Comment> replies = new ArrayList<>();
}
