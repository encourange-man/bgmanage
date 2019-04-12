package com.machen.bgmanager.config;
import com.machen.bgmanager.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  配置类
 *  @author machen
 *  @date 2019-04-01 22:46
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     *添加视图映射
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
     * 注册自己的国际化语言解析器
     */
    @Bean
    public LocaleResolver localResolver() {
        return new MyLocalResolver();
    }

    /**
     * 注册拦截器
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //拦截所有请求，需要过滤掉访问登录页面的请求
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/","/index.html","/user/login","/asserts/**,/webjars/**");
//    }


}
