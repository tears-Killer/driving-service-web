package com.wj.driving.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.wj.driving.exceptions.BaseException;
import com.wj.driving.exceptions.MessageErrorCode;
import com.wj.driving.result.BaseResult;
import com.wj.driving.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName AuthInterceptor
 * @Description TODO
 * @Author wangjian
 * @Date 2020/12/30 16:26
 */
public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(AuthInterceptor.class);

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String autoken = request.getHeader("token");
        log.info("token:{}",autoken);
        if(StringUtils.isBlank(autoken)){
            response.getWriter().print(JSONObject.toJSONString(BaseResult.getFailedResult(MessageErrorCode.请求拦截)));
            return false;
        }
        if(redisUtil.hget(autoken,"id")==null){
            response.getWriter().print(JSONObject.toJSONString(BaseResult.getFailedResult(MessageErrorCode.登陆过期)));
            return false;
        }
            return true;
    }

    private void returnJson(HttpServletResponse response, String json){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
//            LOGGER.error("response error",e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }

}