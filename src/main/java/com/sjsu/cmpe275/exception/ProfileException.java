package com.sjsu.cmpe275.exception;

/**
 * @author chenglongwei
 * @version 1.2
 * @since 2016-03-24
 * When GET/DELETE a nonexistence user profile, ProfileException will be thrown and a page will
 * show the exceptionMsg.
 */
public class ProfileException extends RuntimeException {
    private String exceptionMsg;

    public ProfileException(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
