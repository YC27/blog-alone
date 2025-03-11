package com.ysc.blogalone.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String uploadFileOSS(MultipartFile file);
}
