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

    public static final MessageCode 权限不足 = new MessageCode("权限不足", "401");

    public static final MessageCode 登陆验证失败 = new MessageCode("账号或密码错误", "400");

    public static final MessageCode 请求拦截 = new MessageCode("请先登陆验证", "403");

    public static final MessageCode 登陆过期 = new MessageCode("登陆已过期，请重新登录", "403");

    public static final MessageCode 操作失败 = new MessageCode("服务器内部错误", "500");

    public static final MessageCode 密码修改失败 = new MessageCode("原密码输入错误", "400");

    public MessageErrorCode() {
    }
}