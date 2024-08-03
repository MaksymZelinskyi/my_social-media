package com.javadevmz.my_social_media.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Media extends BaseEntity<Long>{

    private String content;

    @ManyToOne
    private User author;

    private LocalDateTime publishedTime;

    @OneToMany(mappedBy = "media")
    List<Like> likes = new ArrayList<>();

}
