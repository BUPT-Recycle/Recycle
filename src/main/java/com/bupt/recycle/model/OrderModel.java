package com.bupt.recycle.model;

import com.bupt.recycle.entity.OrderDetail;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @anthor tanshangou
 * @time 2018/5/26
 * @description
 */
@Data
public class OrderModel {

    private int orderId;
    private Timestamp createTime;
    private String sellerName;
    private String sellerTel;
    private String sellerAddr;
    private String rsession;
    private Integer workerId;
    private String workerArea;
    private int payState;
    private Double orderAmount;
    private Timestamp orderTime;
    private List<OrderDetail> orderDetail;
}
