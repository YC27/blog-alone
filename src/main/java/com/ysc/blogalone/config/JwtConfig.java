package com.ysc.blogalone.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Data
@Component
@ConfigurationProperties(prefix = "ysc.jwt")
public class JwtConfig {
    private Resource location;
    private String password;
    private String alias;
    private Duration tokenTTL = Duration.ofDays(365);
}
