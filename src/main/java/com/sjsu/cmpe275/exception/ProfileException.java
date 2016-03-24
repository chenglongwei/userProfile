package com.sjsu.cmpe275.exception;

/**
 * Created by chenglongwei on 3/24/16.
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
