package com.example.entry;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ConfigurationProperties:告诉springboot将本类中的属性和配置文件进行绑定
 * @Componet:只有是容器的组件，@ConfigurationProperties才能生效
 */
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarry() {
        return isMarry;
    }

    public void setMarry(boolean marry) {
        isMarry = marry;
    }

    public List<String> getPets() {
        return pets;
    }

    public void setPets(List<String> pets) {
        this.pets = pets;
    }
}
