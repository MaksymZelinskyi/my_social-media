package com.javadevmz.my_social_media.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment extends Entry {


    @ManyToOne
    private User author;

    @ManyToOne
    private Entry commented;

    public Comment(String content) {
        super(content);
    }

    public Comment(String content, User author, Entry commented) {
        super(content);
        this.author = author;
        this.commented = commented;
    }
}
