package com.javadevmz.my_social_media.dao.entity;

import com.javadevmz.my_social_media.dao.entity.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString(exclude = {"entrys", "subscriptions", "followers", "likes", "roles"})
public class User extends BaseEntity<Long> {

    @Email
    @NaturalId
    @EqualsAndHashCode.Include
    @Column(unique = true)
    private String email;

    @NaturalId
    @Column(unique = true)
    @EqualsAndHashCode.Include
    private String username;

    @OneToOne
    private Attachment profilePicture;

    private PersonalInfo personalInfo;
    private String password;
    private LocalDate registrationDate = LocalDate.now();


    /*
        Not used because fetching even a One-To-Many alternative of a self referencing  Many-to-Many
        relation is not efficient, and it's better to use UserSubscription queries directly instead.
        *kept for emphasis
     */
    @OneToMany(mappedBy = "follower", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<UserSubscription> subscriptions = new ArrayList<>();

    @OneToMany(mappedBy = "subscription", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<UserSubscription> followers = new ArrayList<>();

    @OrderBy("publishedTime desc")
    @OneToMany(mappedBy = "author", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Like> likes = new ArrayList<>();

    @ElementCollection
    private List<String> roles = new ArrayList<>();
}
