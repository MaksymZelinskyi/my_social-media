package com.javadevmz.my_social_media.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attachment extends AbstractEntity<Long> {

    private String name;
    private byte[] content;
    private String mediaType;
}
