package com.javadevmz.my_social_media.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public record Birthday(LocalDate birthday) {

    public int getAge(){
        return (int)ChronoUnit.YEARS.between(birthday, LocalDate.now());
    }
}
