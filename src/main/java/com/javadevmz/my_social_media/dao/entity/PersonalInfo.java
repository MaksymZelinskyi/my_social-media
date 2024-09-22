package com.javadevmz.my_social_media.dao.entity;

import com.javadevmz.my_social_media.converter.BirthdayLocalDateConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PersonalInfo {

    private String firstName;
    private String lastName;

    @Convert(converter = BirthdayLocalDateConverter.class)
    @Column(nullable = false)
    private Birthday birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
