package com.bupt.recycle.exception;

import com.bupt.recycle.Enum.ResultEnum;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description 针对于回收员的异常类，
 * 继承了Runtime异常便于用在各种异常处理环境
 */
public class WorkerException extends RuntimeException {

    private Integer code;


    /**
     *
     * @param code
     * @param msg
     */
    public WorkerException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
