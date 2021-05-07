package com.wj.driving.exceptions;

/**
 * <p>
 *  数据校验异常
 * </p>
 *
 * @author wangjian
 * @since 2021/4/28
 */
public class DataValidateException extends BaseException{


    public DataValidateException() {
        super();
    }

    public DataValidateException(String msg) {
        super(msg);
    }

    public DataValidateException(String msg, Throwable ex) {
        super(msg, ex);
    }

    public DataValidateException(Throwable ex) {
        super(ex);
    }

}