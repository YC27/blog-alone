package com.ysc.blogalone.exception;

import com.ysc.blogalone.util.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(YscException.class)
    @ResponseBody
    public R error(YscException e){
        e.printStackTrace();
        return R.error().code(e.getMsg(), e.getCode());
    }


}
