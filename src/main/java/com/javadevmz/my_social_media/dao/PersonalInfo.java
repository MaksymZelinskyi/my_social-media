package com.javadevmz.my_social_media.dao;

import jakarta.persistence.*;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;

@Embeddable
public class PersonalInfo {

    private String firstName;
    private String lastName;
    @Convert(converter = BirthdayLocalDateConverter.class)
    private Birthday birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
