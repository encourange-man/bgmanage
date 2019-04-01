package com.machen.bgmanager.controller;

import com.machen.bgmanager.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * RestController : 相当于就是Controller和ResponseBody
 * @author machen
 * @date 2019-04-01 22:33
 */
@Controller
public class LoginController {

    private  Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     *  如果@RequestParam中没有username，将会报错
     * @param username
     * @param password
     * @param session
     * @param map
     * @return
     */
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Map<String,Object> map){

        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            logger.info(username+" 登录成功");
            session.setAttribute("userId",username);
            //登录成功,防止表单重复提交，可以重定向到主页
            return "redirect:/main.html";
        }else{
            //登录失败
            map.put("msg","用户名或密码错误！");
            logger.info(username+"[用户名或密码错误！]");
            return "login";
        }
    }
}
