package com.ysc.blogalone.entity.user.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="用户修改密码的DTO对象", description="")
public class PasswordDTO implements Serializable {
    private String rawPassword;
    private String newPassword;
}
