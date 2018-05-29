package com.bupt.recycle.service;

import com.bupt.recycle.entity.Order;
import com.bupt.recycle.model.OrderModel;

import java.util.List;

/**
 * @anthor tanshangou
 * @time 2018/5/26
 * @description
 */
public interface OrderService {

    Order createOrder(OrderModel orderModel);

    Object getAnOrder(int orderId);

    List<Order> getOrderList(String openid);

    //Object getOrderDetail();
}
