package com.ysc.blogalone.entity.article.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BlogDto对象", description="")
public class BlogDto implements Serializable {
    private String title;
    private String content;
    private Long tagId;
    private String blogSort;
    private Integer blogPrivate;
    private Integer blogStatus;
    private Long userId;
    private String previewTheme;
    private String codeTheme;
    private String theme;
}
