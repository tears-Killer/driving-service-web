/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @ClassName BaseException
 * @Description TODO
 * @Author wangjian
 * @Date 2021/1/6 9:46
 */
public class BaseException extends RuntimeException{

    /**
     * @Description: 获取异常的StackTrace的字符串
     * @param @param
     *            e
     * @param @return
     * @return String
     */
    public static String getStackTraceAsString(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /**
     *
     */
    private Throwable cause;

    private MessageCode messsageCode;

    /**
     * 业务异常缺省构造函数
     * <p>
     * Description:
     * </p>
     */
    public BaseException() {
        super();
    }

    public BaseException(MessageCode message) {
        super(message.getDescription());

        this.messsageCode = message;
    }

    /**
     * 业务异常构造函数，传入缺省消息
     * <p>
     * Description:
     * </p>
     *
     * @param msg
     */
    public BaseException(String msg) {
        super(msg);
    }

    /**
     * 将当前异常消息和异常加入异常堆栈
     * <p>
     * Description:
     * </p>
     *
     * @param msg
     * @param th
     */
    public BaseException(String msg, Throwable ex) {
        super(msg, ex);
        this.cause = ex;
    }

    /**
     * 将当前异常加入异常堆栈
     * <p>
     * Description:
     * </p>
     *
     * @param th
     */
    public BaseException(Throwable ex) {
        super(ex);
        this.cause = ex;
    }

    @Override
    public Throwable getCause() {
        return (this.cause == null ? this : this.cause);
    }

    /**
     * 获取异常消息
     *
     * @return
     */
    public String getErrorCode() {
        if (super.getCause() != null) {
            return super.getCause().getMessage();
        } else {
            return "";
        }
    }

    /**
     * 获取异常信息详情
     */
    public String getErrorMessage() {
        return super.getMessage();
    }

    /**
     * Get the BusinessException Message
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public MessageCode getMesssageCode() {
        return messsageCode;
    }

    /*
     * 获取原始的消息信息
     */
    protected String getOriginalMessage() {
        return super.getMessage();
    }

    public void setMesssageCode(MessageCode messsageCode) {
        this.messsageCode = messsageCode;
    }


}