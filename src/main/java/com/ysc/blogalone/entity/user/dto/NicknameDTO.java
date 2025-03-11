package com.ysc.blogalone.entity.user.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="用户昵称更新的DTO对象", description="")
public class NicknameDTO implements Serializable {
    private String nickname;
}
