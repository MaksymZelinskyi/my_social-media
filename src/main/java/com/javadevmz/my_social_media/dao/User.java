package com.javadevmz.my_social_media.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity<Long> {

    @Email
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
