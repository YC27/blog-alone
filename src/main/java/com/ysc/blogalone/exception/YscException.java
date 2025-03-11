package com.ysc.blogalone.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class YscException extends RuntimeException{
    @ApiModelProperty(value = "状态码")
    private Integer code;

    private String msg;

    public YscException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public YscException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
