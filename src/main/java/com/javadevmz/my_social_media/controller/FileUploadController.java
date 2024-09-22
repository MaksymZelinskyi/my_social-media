package com.javadevmz.my_social_media.controller;

import com.javadevmz.my_social_media.dao.entity.Attachment;
import com.javadevmz.my_social_media.service.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @Autowired
    private FileManager fileManager;

    @PostMapping("/upload-file")
    public Attachment uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        return fileManager.saveFile(file);
    }
}
