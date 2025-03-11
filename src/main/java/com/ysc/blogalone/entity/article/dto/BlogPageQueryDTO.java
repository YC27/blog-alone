package com.ysc.blogalone.entity.article.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BlogPageDTO对象", description="")
public class BlogPageQueryDTO implements Serializable {
    private Long blogId;
    private Long userId;

}
