package com.wj.driving.util;


import com.wj.driving.result.Result;
import com.wj.driving.result.ResultEnum;

public class ResultUtil {
    public static <T> Result<T> defineSuccess(Integer code, T data) {
        Result<Object> result = new Result<>();
        return result.setCode(code).setData(data);
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setCode(ResultEnum.SUCCESS).setMsg("请求成功").setData(data);
        return result;
    }

    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.FAIL).setMsg(msg);
        return result;
    }

    public static <T> Result<T> defineFail(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code).setMsg(msg);
        return result;
    }

    public static <T> Result<T> define(int code, String msg, T data) {
        Result<T> result = new Result<T>();
        result.setCode(code).setMsg(msg).setData(data);
        return result;
    }
}