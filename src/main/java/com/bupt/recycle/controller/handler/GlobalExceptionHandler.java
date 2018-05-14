package com.bupt.recycle.controller.handler;

import com.bupt.recycle.exception.WorkerException;
import com.bupt.recycle.model.ResultModel;
import com.bupt.recycle.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description 全局异常处理
 */

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value=WorkerException.class)
    @ResponseBody
    public ResultModel workerExceptionHandler(Exception e){
        if(e instanceof WorkerException){
            WorkerException workerException= (WorkerException)e;
            return ResultUtil.error(workerException.getCode(),workerException.getMessage());
        }
        return ResultUtil.error(-1,e.getMessage());
    }

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public ResultModel defaulExceptionHandler(Exception e){
        return ResultUtil.error(-1,e.getMessage());
    }

}
