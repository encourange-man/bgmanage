package com.machen.bgmanager.mapper;

import com.machen.bgmanager.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * UserMapper
 *
 * @author machen
 * @date 2019-04-03 11:36
 */
@Component
@Mapper
public interface UserMapper {

    /**
     * 通过用户id获取用户信息
     * @param id
     * @return
     */
    @Select("select * from ums_admin where id= #{id}")
     User getUserById(int id);
}
