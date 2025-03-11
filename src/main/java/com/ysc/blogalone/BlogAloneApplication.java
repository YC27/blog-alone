package com.ysc.blogalone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.ysc")
@SpringBootApplication
@MapperScan("com.ysc.blogalone.mapper")
public class BlogAloneApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogAloneApplication.class, args);
    }

}
