package com.bupt.recycle.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @anthor tanshangou
 * @time 2018/5/27
 * @description
 */
@Entity
@Table(name = "myorder", schema = "recycle")

public class Order {
    private int orderId;
    private Timestamp createTime;
    private String sellerName;
    private String sellerTel;
    private String sellerAddr;
    private String sellerOpenid;
    private Integer workerId;
    private String workerArea;
    private int payState;
    private Double orderAmount;
    private String orderTime;

    @Id
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "seller_name", nullable = true, length = 32)
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Basic
    @Column(name = "seller_tel", nullable = true, length = 32)
    public String getSellerTel() {
        return sellerTel;
    }

    public void setSellerTel(String sellerTel) {
        this.sellerTel = sellerTel;
    }

    @Basic
    @Column(name = "seller_addr", nullable = true, length = 1024)
    public String getSellerAddr() {
        return sellerAddr;
    }

    public void setSellerAddr(String sellerAddr) {
        this.sellerAddr = sellerAddr;
    }

    @Basic
    @Column(name = "seller_openid", nullable = true, length = 64)
    public String getSellerOpenid() {
        return sellerOpenid;
    }

    public void setSellerOpenid(String sellerOpenid) {
        this.sellerOpenid = sellerOpenid;
    }

    @Basic
    @Column(name = "worker_id", nullable = true)
    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    @Basic
    @Column(name = "worker_area", nullable = true, length = 32)
    public String getWorkerArea() {
        return workerArea;
    }

    public void setWorkerArea(String workerArea) {
        this.workerArea = workerArea;
    }

    @Basic
    @Column(name = "pay_state", nullable = true)
    public int getPayState() {
        return payState;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    @Basic
    @Column(name = "order_amount", nullable = true, precision = 0)
    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Basic
    @Column(name = "order_time", nullable = true)
    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId &&
                payState == order.payState &&
                Objects.equals(createTime, order.createTime) &&
                Objects.equals(sellerName, order.sellerName) &&
                Objects.equals(sellerTel, order.sellerTel) &&
                Objects.equals(sellerAddr, order.sellerAddr) &&
                Objects.equals(sellerOpenid, order.sellerOpenid) &&
                Objects.equals(workerId, order.workerId) &&
                Objects.equals(workerArea, order.workerArea) &&
                Objects.equals(orderAmount, order.orderAmount) &&
                Objects.equals(orderTime, order.orderTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, createTime, sellerName, sellerTel, sellerAddr, sellerOpenid, workerId, workerArea, payState, orderAmount, orderTime);
    }
}
