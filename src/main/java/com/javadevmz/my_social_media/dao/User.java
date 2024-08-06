package com.javadevmz.my_social_media.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.validation.annotation.Validated;

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
@ToString(exclude = {"medias", "subscriptions", "followers", "likes"})
public class User extends BaseEntity<Long> {

    @Email
    @NaturalId
    @EqualsAndHashCode.Include
    @Column(unique = true)
    private String email;

    private PersonalInfo personalInfo;
    private String password;
    private LocalDate registrationDate;

    @OneToMany(mappedBy = "follower", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<UserSubscription> subscriptions = new ArrayList<>();

    @OneToMany(mappedBy = "followed", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<UserSubscription> followers = new ArrayList<>();

    @OneToMany(mappedBy = "author", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Media> medias = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Like> likes = new ArrayList<>();

}
