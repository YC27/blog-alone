package com.ysc.blogalone.entity.article.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TagDto对象", description="")
public class TagDto implements Serializable {
    private Long tagId;
    private Long userId;
    private String tagName;
}
