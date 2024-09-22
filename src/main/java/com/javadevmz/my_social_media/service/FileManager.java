package com.javadevmz.my_social_media.service;

import com.javadevmz.my_social_media.dao.entity.Attachment;
import com.javadevmz.my_social_media.dao.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileManager {

    @Autowired
    private FileRepository fileRepository;

    public Attachment saveFile(MultipartFile file) throws IOException {
        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setMediaType(file.getContentType());
        attachment.setContent(file.getBytes());
        return fileRepository.save(attachment);
    }
}
