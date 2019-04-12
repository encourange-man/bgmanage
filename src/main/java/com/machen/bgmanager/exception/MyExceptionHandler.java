package com.machen.bgmanager.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理：返回异常json数据，并跳转到响应的错误页面
 * @author machen
 * @date 2019-04-01 22:46
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
    public String  handlerException(UserException e, HttpServletRequest request, HttpServletResponse response){
        logger.error("code:{} 自定义异常:{}",response.getStatus(),e.getMessage());

        HashMap<String, Object> map = new HashMap<>();
        map.put("message",e.getMessage());
        map.put("code",response.getStatus());

        //需要设置错误status，这样Handler就会跳转到响应的错误页面
        request.setAttribute("error",map);
        request.setAttribute("javax.servlet.error.status_code",response.getStatus());

        //转发到/error请求，BasicErrorController就会处理错误请求
        return "redirect:/error";
    }

}
