package com.ysc.blogalone.entity.user;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yc
 * @since 2023-12-14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @ApiModelProperty(value = "用户登录账号, 用户名")
    private String username;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "用户登录密码")
    private String password;

    @ApiModelProperty(value = "用户登录邮箱")
    private String email;

    @ApiModelProperty(value = "用户性别")
    private String gender;

    @ApiModelProperty(value = "粉丝数量")
    private Integer fanNumber;

    @ApiModelProperty(value = "关注数量")
    private Integer followNumber;

    @ApiModelProperty(value = "收藏数量")
    private Integer collectNumber;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户是否封号")
    private Integer ban;

    @ApiModelProperty(value = "用户是否禁用")
    private Integer enabled;

    @ApiModelProperty(value = "账户是否没有过期0已过期 1 正常")
    private Integer accountNoExpired;

    @ApiModelProperty(value = "密码是否没有过期0已过期 1 正常")
    private Integer credentialsNoExpired;

    @ApiModelProperty(value = "账户是否没有锁定0已锁定 1 正常")
    private Integer accountNoLocked;

    @ApiModelProperty(value = "用户注册时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "用户修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
