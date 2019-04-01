package com.machen.bgmanager.component;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义拦截器，拦截登录请求
 *
 * @author machen
 * @date 2019-04-01 22:33
 */
public class MyComponent implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        Locale local = Locale.getDefault();

        if(StringUtils.isEmpty(l)){
            String[] s = l.split("_");
            local= new Locale(s[0],s[1]);
        }
        return local;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }



}
