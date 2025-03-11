package com.ysc.blogalone.entity.article.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UpdateClassificationDTO对象", description="")
public class UpdateClassificationDTO implements Serializable {
    private Integer classificationId;
    private String classificationTitle;
}
