package com.ainilzb.exception;

import com.ainilzb.utils.IMOOCJSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@RestControllerAdvice
public class CustomExceptionHandler {

    //上传文件超过500kb，捕获异常MaxUploadSizeExceededException
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public IMOOCJSONResult handlerMaxUploadFile(MaxUploadSizeExceededException ex){
        return IMOOCJSONResult.errorMsg("文件上传大小不能超过500kb，请压缩或者降低文件质量再上传！");

    }
}
