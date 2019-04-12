package com.machen.bgmanager;

import com.machen.bgmanager.entity.User;
import com.machen.bgmanager.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BgManagerApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void TestGetUser(){
        User user = userMapper.getUserById(4);
        System.out.println(user);
    }
}
