/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.common.interceptor;

import com.wj.driving.exceptions.MessageCode;
import com.wj.driving.result.BaseResult;
import com.wj.driving.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName AuthInterceptor
 * @Description TODO
 * @Author wangjian
 * @Date 2020/12/30 16:26
 */
public class AuthInterceptor implements HandlerInterceptor {


    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String autoken = request.getHeader("token");
        if(autoken==null){
            response.getWriter().println(BaseResult.getFailedResult("请先登陆验证"));
            return false;
        }
        if(redisUtil.hget(autoken,"id")==null){
            response.getWriter().println(BaseResult.getFailedResult("登陆已过期，请重新登录"));
            return false;
        }
            return true;
    }
}