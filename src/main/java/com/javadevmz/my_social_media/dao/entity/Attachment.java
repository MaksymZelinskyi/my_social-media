package com.javadevmz.my_social_media.dao.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.MediaType;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Attachment extends BaseEntity<Long>{

    private String name;
    private byte[] content;
    private MediaType mediaType;
}
