package com.wj.driving.exceptions;

/**
 * @ClassName MessageErrorCode
 * @Description TODO
 * @Author wangjian
 * @Date 2021/1/6 10:17
 */
public class MessageErrorCode {

    public static final MessageCode 服务器内部错误 = new MessageCode("服务器内部错误", "500");

    public static final MessageCode NOT_FOUND = new MessageCode("页面丢失", "404");

    public static final MessageCode 权限不足 = new MessageCode("权限不足", "403");
}