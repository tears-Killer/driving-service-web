package com.wj.driving.result;

import com.wj.driving.exceptions.BaseException;
import com.wj.driving.exceptions.MessageCode;
import com.wj.driving.exceptions.MessageErrorCode;

/**
 * @ClassName BaseResult
 * @Description TODO
 * @Author wangjian
 * @Date 2021/1/6 9:38
 */
public class BaseResult {
    /*
    * 返回状态码
    */
    private String status;
    /*
     * 错误消息
     */
    private String msg;
    /*
     * 错误详情
     */
    private String desc;
    /*
     * 服务当前时间
     */
    private String serviceTime;
    /*
     * 返回的数据
     */
    private Object data;

    private BaseResult(Object data){
        this.setStatus("200");
        this.setMsg("请求成功");
        this.setServiceTime(String.valueOf(System.currentTimeMillis()));
        this.setData(data);
    }

    private BaseResult(Exception e){
        setMsg("有异常问题");
        setServiceTime(String.valueOf(System.currentTimeMillis()));
        setData(null);
        if (e instanceof BaseException) {
            BaseException baseException = (BaseException) e;
            if (baseException.getMesssageCode() == null) {
                status = " ";
                desc = baseException.getMessage();
            } else {
                status = baseException.getMesssageCode().getErrorCode();
                desc = baseException.getMesssageCode().getDescription();
            }
        } else {
            status = MessageErrorCode.服务器内部错误.getErrorCode();
            desc = MessageErrorCode.服务器内部错误.getDescription();
        }
    }

    private BaseResult(String msg){
        this.setStatus(MessageErrorCode.服务器内部错误.getErrorCode());
        this.setMsg(msg);
        this.setDesc(MessageErrorCode.服务器内部错误.getDescription());
        this.setServiceTime(String.valueOf(System.currentTimeMillis()));
        this.setData(null);
    }


    public static BaseResult getSuccessResult(Object data) {
        return new BaseResult(data);
    }

    public static BaseResult getFailedResult(Exception e) {
        return new BaseResult(e);
    }

    public static BaseResult getFailedResult(String msg) {
        return new BaseResult(msg);
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}