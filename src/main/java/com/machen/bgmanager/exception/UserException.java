package com.machen.bgmanager.exception;

/**
 * 自定义错误 UserException
 * @author machen
 * @date 2019-04-01 22:46
 */
public class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);
    }
}
