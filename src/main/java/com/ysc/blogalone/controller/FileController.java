package com.ysc.blogalone.controller;

import com.ysc.blogalone.service.FileService;
import com.ysc.blogalone.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@CrossOrigin
@RequiredArgsConstructor
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("uploadFile")
    public R uploadFile(MultipartFile file){
        //1获取文件
        //2调用接口上传文件，获取Url
        String url = fileService.uploadFileOSS(file);
        return R.ok().data("url",url);
    }

    @GetMapping("test")
    public String test() {
        return "Hello";
    }

}
