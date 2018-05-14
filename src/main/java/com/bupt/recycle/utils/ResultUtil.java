package com.bupt.recycle.utils;

import com.bupt.recycle.Enum.ResultEnum;
import com.bupt.recycle.model.ResultModel;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */
public class ResultUtil {

    public static ResultModel success(Object object){
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(0);
        resultModel.setMsg("success");
        resultModel.setData(object);
        return resultModel;
    }

    public static ResultModel success(){

        return success(null);
    }


    /**
     * 一般情况下，error函数只允许异常处理类进行调用，直接调用该类返回错误信息
     * @param code
     * @param msg
     * @return
     */

    public static ResultModel error(Integer code,String msg){
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(code);
        resultModel.setMsg(msg);
        resultModel.setData(null);
        return resultModel;
    }


}
