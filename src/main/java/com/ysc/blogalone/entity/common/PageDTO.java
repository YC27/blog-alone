package com.ysc.blogalone.entity.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PageDTO对象", description="")
public class PageDTO<T> implements Serializable {
    private Long size;
    private Long currentPage;
    private List<T> list;
}
