package com.central.post.controller;

import com.central.post.util.JsonResult;
import com.central.post.exception.Exceptions;
import com.central.post.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//控制层类的基类
public class BaseController {
    //异常捕获
    //操作成功的状态码
    public static final int ok = 200;
    public static final int err = 400;

    //当项目中产生了异常,会被统一拦截到此方法中,方法的返回值会被传给前端
    @ExceptionHandler(Exception.class)// 用于统一处理抛出的异常
    public JsonResult<Map<String, String>> handleException(Throwable e) {
        JsonResult<Map<String, String>> result = new JsonResult<>(e);
        if (e instanceof ServiceException) {
            Exceptions exceptionEnum = ((ServiceException) e).getServiceExceptionEnums();
            result.setState(exceptionEnum.getCode());
            result.setMessage(exceptionEnum.getMessage());
            HashMap<String, String> map = new HashMap<>();
            map.put("detail", ((ServiceException) e).getExceptionDetail());
            result.setData(map);
        } else {
            result.setState(0);
            result.setMessage(e.getMessage());
            HashMap<String, String> map = new HashMap<>();
            map.put("detail", Arrays.toString(e.getStackTrace()));
            result.setData(map);
            e.printStackTrace();
        }
        return result;
    }

}
