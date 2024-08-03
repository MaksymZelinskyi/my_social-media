package com.javadevmz.my_social_media.dao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends Media{

    private String title;

    @OneToMany(mappedBy = "media", orphanRemoval = true, cascade = CascadeType.REMOVE)
    List<Comment> comments = new ArrayList<>();

}
