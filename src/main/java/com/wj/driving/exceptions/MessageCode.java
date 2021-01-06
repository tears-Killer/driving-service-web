package com.wj.driving.exceptions;

/**
 * @ClassName MessageCode
 * @Description TODO
 * @Author wangjian
 * @Date 2021/1/6 9:48
 */
public class MessageCode {

    private String description;

    private String errorCode;


    public MessageCode(String description, String errorCode) {
        this.description = description;
        this.errorCode = errorCode;
    }

    public MessageCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}