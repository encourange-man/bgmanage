package com.machen.bgmanager.entity;

import lombok.Data;

/**
 * user
 * @author machen
 * @date 2019-04-03 11:13
 */
@Data
public class User {
    private int id;
    private String userName;
    private String passWord;
    private String ip;
}
