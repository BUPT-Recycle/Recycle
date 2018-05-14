package com.bupt.recycle.model;

import lombok.Data;


/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */

@Data
public class ResultModel<T> {

    private int code;

    private String msg;

    private T data;


}
