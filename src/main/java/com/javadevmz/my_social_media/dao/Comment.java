package com.javadevmz.my_social_media.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment extends Media{

    @ManyToOne
    private Media media;

    @OneToMany(mappedBy = "media", orphanRemoval = true)
    List<Comment> replies = new ArrayList<>();
}
