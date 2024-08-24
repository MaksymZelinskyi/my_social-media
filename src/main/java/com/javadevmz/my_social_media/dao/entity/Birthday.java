package com.javadevmz.my_social_media.dao.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record Birthday(LocalDate birthday) {

    public int getAge(){
        return (int)ChronoUnit.YEARS.between(birthday, LocalDate.now());
    }
}
