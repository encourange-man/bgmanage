package com.machen.bgmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  项目启动类
 *
 *  @author machen
 *  @date 2019-04-03 11:36
 */
@MapperScan("com.machen.bgmanager.mapper")
@SpringBootApplication
public class BgManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgManagerApplication.class, args);
    }

}
