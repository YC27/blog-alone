package com.ysc.blogalone.entity.article;

import com.baomidou.mybatisplus.annotation.*;
import com.ysc.blogalone.entity.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Blog对象", description="")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "博客主键")
    @TableId(value = "blog_id", type = IdType.AUTO)
    private Long blogId;

    @ApiModelProperty(value = "所属用户")
    private Long userId;

    @ApiModelProperty(value = "博客分类(前端、后端等)")
    private String blogSort;

    @ApiModelProperty(value = "分类夹id")
    private Integer classificationId;

    @ApiModelProperty(value = "标签")
    private Long tagId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "博客状态(0 草稿，1 发布，2 下架)")
    private Integer blogStatus;

    @ApiModelProperty(value = "博客是否私有(0 私有，1公开)")
    private Integer blogPrivate;

    @ApiModelProperty(value = "预览主题")
    private String previewTheme;

    @ApiModelProperty(value = "代码主题")
    private String codeTheme;

    @ApiModelProperty(value = "主题")
    private String theme;

    @ApiModelProperty(value = "文章封面")
    private String coverSrc;

    @ApiModelProperty(value = "文章是否有封面")
    private Integer hasCover;

    @ApiModelProperty(value = "浏览数量")
    private Integer browseNumber;

    @ApiModelProperty(value = "点赞数量")
    private Integer likeNumber;

    @ApiModelProperty(value = "收藏数量")
    private Integer collectNumber;

    @ApiModelProperty(value = "是否删除")
    @TableLogic
    private Integer isDelete;

    @ApiModelProperty(value = "文章发布时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "文章修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "用户")
    @TableField(exist = false)
    private User user;

    @ApiModelProperty(value = "标签")
    @TableField(exist = false)
    private ArticleTag articleTag;

    @ApiModelProperty(value = "分类夹")
    @TableField(exist = false)
    private Classification classification;


}
