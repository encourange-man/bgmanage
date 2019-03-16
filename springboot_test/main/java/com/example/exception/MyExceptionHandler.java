package com.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * ControllerAdvice：控制器增强器
 */
@ControllerAdvice
public class MyExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    /**
     * UserException：抛出来的异常会被此拦截器拦截
     * @return
     */
    @ResponseBody
    @ExceptionHandler(UserException.class)
    public String  handlerException(UserException e, HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        map.put("message",e.getMessage());
        map.put("code","500");

        request.setAttribute("error",map);
        //需要设置错误status，这样Handler就会跳转到响应的错误页面
        request.setAttribute("javax.servlet.error.status_code",400);

        //转发到/error请求，BasicErrorController就会处理错误请求
        return "redirect:/error";
    }

}
