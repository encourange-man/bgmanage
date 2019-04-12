package com.machen.bgmanager.component;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 *  todo : 这里并没有生效，有待研究
 *  自定义国际化语言解析器
 * @author machen
 * @date 2019-04-01 22:33
 */
public class MyLocalResolver implements LocaleResolver {
    Logger logger = LoggerFactory.getLogger(MyLocalResolver.class);

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        logger.info("【MyLocalResolver】：resolveLocale get  param is "+httpServletRequest.getParameter("l"));

        String l = httpServletRequest.getParameter("l");
        System.out.println(l);

        Locale local = Locale.getDefault();
        
        System.out.println(l);
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
