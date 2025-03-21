package com.ysc.blogalone.service.impl;

import cn.hutool.core.date.DateTime;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.ysc.blogalone.exception.YscException;
import com.ysc.blogalone.service.FileService;
import com.ysc.blogalone.util.ConstantPropertiesUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    //上传文件
    @Override
    public String uploadFileOSS(MultipartFile file) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = ConstantPropertiesUtil.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;
        String fileName = file.getOriginalFilename();

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);


        try {
            //上传文件流
            InputStream inputStream = file.getInputStream();
            //优化文件名（11112222+01.jpg）
            fileName = UUID.randomUUID().toString()+fileName;
            //优化文件存储路径（/2022/12/30/uuid+01.jpg）
            String path = new DateTime().toString("yyyy/MM/dd");
            fileName = path+"/"+fileName;

            ossClient.putObject(bucketName, fileName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
            //https://guli-file201021.oss-cn-beijing.aliyuncs.com/01.jpg
            String url ="https://"+bucketName+"."+endpoint+"/"+fileName;
            return url;

        } catch (IOException e) {
            e.printStackTrace();
            throw  new YscException(20001, "文件太大了");
        }

    }
}
