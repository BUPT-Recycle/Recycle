package com.bupt.recycle.Enum;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description 返回结果枚举集
 */
public enum ResultEnum {

    REGISTER_FAILED(1,"register failed"),
    WX_MP_ERROR(20,"微信公众账号方面错误")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
