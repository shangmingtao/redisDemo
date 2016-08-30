package com.my.redis.vo;

/**
 * Created by mac on 16/8/27.
 */
public class RedisResultVo<T> {

    boolean errorFlag = Boolean.valueOf(true); //返回结果,默认为true

    String msg = "成功";  //返回结果,默认为成功

    T obj ; //返回数据对象

    public boolean isErrorFlag() {
        return errorFlag;
    }

    public void setErrorFlag(boolean errorFlag) {
        this.errorFlag = errorFlag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
