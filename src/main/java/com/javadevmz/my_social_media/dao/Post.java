package com.javadevmz.my_social_media.dao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "comments", callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Post extends Media{

    private String title;

    @OneToMany(mappedBy = "media", orphanRemoval = true, cascade = CascadeType.REMOVE)
    List<Comment> comments = new ArrayList<>();


}
