package com.ysc.blogalone.entity.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="用户登录的DTO对象", description="")
public class LoginDTO implements Serializable {

    @ApiModelProperty(value = "用户登录账号, 用户名")
    private String username;

    @ApiModelProperty(value = "用户登录密码")
    private String password;
}
