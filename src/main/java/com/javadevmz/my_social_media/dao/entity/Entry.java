package com.javadevmz.my_social_media.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public abstract class Entry extends AbstractEntity<Long> {

    private String text;

    @ManyToOne
    private User author;

    private LocalDateTime publishedTime = LocalDateTime.now();

    private LocalDateTime lastEdit = LocalDateTime.now();

    @OneToOne
    private Attachment attachment;

    /*
    @OneToMany(mappedBy = "commented", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        getComments().add(comment);
        comment.setCommented(this);
    }

    @OneToMany(mappedBy = "post", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<Like> likes = new ArrayList<>();


    public void addLike(Like like) {
        like.setEntry(this);
        getLikes().add(like);
    }
*/
    //removed because it is more efficient and much more predictable to use a simple @ManyToOne
    // reationship at the child-side and to operate with the elements through a repository.
    //Additionally, I wrote a mechanism using pagination to retrieve the entities in batches

    public Entry(String text) {
        this.text = text;
    }

}
