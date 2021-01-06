package com.wj.driving.result;

import com.wj.driving.exceptions.BaseException;
import com.wj.driving.exceptions.MessageCode;
import com.wj.driving.exceptions.MessageErrorCode;

import java.util.Date;

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
    private Date serviceTime;
    /*
     * 返回的数据
     */
    private Object data;

    private BaseResult(Object data){
        this.setStatus("200");
        this.setMsg("请求成功");
        this.setDesc("");
        this.setServiceTime(getCurrentTime());
        this.setData(data);
    }

    private BaseResult(Exception e){
        setMsg("有异常问题");
        setServiceTime(getCurrentTime());
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
        this.setStatus("400");
        this.setMsg("请求失败");
        this.setDesc(msg);
        this.setServiceTime(getCurrentTime());
        this.setData(null);
    }

    private static Date getCurrentTime(){
        return new Date(System.currentTimeMillis());
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

    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", desc='" + desc + '\'' +
                ", serviceTime=" + serviceTime +
                ", data=" + data +
                '}';
    }
}