package com.sjsu.cmpe275.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author chenglongwei
 * @version 1.2
 * @since 2016-03-24
 * When GET/DELETE a nonexistence user profile, ProfileException will be thrown and a page will
 * show the exceptionMsg.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Sorry, the requested user with ID does not exist.")  // 404
public class ProfileException extends RuntimeException {
    private String exceptionMsg;

    public ProfileException(String exceptionMsg) {
        super(exceptionMsg);
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
