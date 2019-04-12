package com.machen.bgmanager.service;

import com.machen.bgmanager.entity.User;
import com.machen.bgmanager.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *  UserService
 *
 * @author machen
 * @date 2019-04-03 11:28
 */
@Service
public class UserService {

    private Logger log = LoggerFactory.getLogger(UserMapper.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 通过用户id获取用户信息
     */
    public User getUserById(int id){
        log.info("【getUserById】param is {}"+id);

        User user = userMapper.getUserById(id);

        log.info("【getUserById】return is id=: "+user);
        return user;
    }
}
