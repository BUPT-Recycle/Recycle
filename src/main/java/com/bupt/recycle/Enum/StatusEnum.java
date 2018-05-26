package com.bupt.recycle.Enum;

/**
 * @anthor tanshangou
 * @time 2018/5/26
 * @description
 */
public enum StatusEnum {

    HAS_PAY(2),
    WAIT_PAY(1),
    NOT_PAY(0);

    private int pay_status;

    StatusEnum(int pay_status){
        this.pay_status=pay_status;
    }


    public int getPay_status() {
        return pay_status;
    }

    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }
}
