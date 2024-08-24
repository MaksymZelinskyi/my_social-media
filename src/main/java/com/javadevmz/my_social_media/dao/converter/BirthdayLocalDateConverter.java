package com.javadevmz.my_social_media.dao.converter;

import com.javadevmz.my_social_media.dao.entity.Birthday;
import jakarta.persistence.AttributeConverter;

import java.time.LocalDate;

public class BirthdayLocalDateConverter implements AttributeConverter<Birthday, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(Birthday birthday) {
        return birthday.birthday();
    }

    @Override
    public Birthday convertToEntityAttribute(LocalDate localDate) {
        return new Birthday(localDate);
    }
}
