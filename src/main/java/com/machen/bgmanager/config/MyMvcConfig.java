package com.machen.bgmanager.config;

/**
 * Demo class
 *
 * @author machen
 * @date 2019-04-01 22:46
 */

import com.machen.bgmanager.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义mcv config,需要继承WebMvcConfigurer接口
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 添加视图控制，将指定路径的请求转到指定的页面下
     * 从安全考虑，还需要添加过滤器来过滤，非必须的请求
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求，需要过滤掉访问登录页面的请求
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/index.html","/user/login");
    }

}
