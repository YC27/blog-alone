package com.ysc.blogalone.entity.article.dto;


import com.ysc.blogalone.entity.article.Blog;
import com.ysc.blogalone.entity.common.PageDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BlogPageDTO对象", description="")
public class BlogPageDTO extends PageDTO<Blog> {
    private Integer blogStatus;
    private Integer blogPrivate;
    private Integer classificationId;
    private Long userId;
    private Long tagId;
    private String tagName;
    private String blogSort;
    private Date updateTime;
    private String title;
    private String sortStr;
}
