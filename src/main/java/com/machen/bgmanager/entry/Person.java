package com.machen.bgmanager.entry;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @ConfigurationProperties:告诉springboot将本类中的属性和配置文件进行绑定
 * @Componet:只有是容器的组件，@ConfigurationProperties才能生效
 *  @author machen
 *  @date 2019-04-01 22:33
 */
@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private int age;
    private boolean isMarry;
    private List<String> pets;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMarry=" + isMarry +
                ", pets=" + pets +
                '}';
    }
}
