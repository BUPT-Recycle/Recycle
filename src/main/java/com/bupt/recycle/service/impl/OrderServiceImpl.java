package com.bupt.recycle.service.impl;

import com.bupt.recycle.entity.Order;
import com.bupt.recycle.entity.OrderDetail;
import com.bupt.recycle.model.OrderModel;
import com.bupt.recycle.repository.OrderDetailRepository;
import com.bupt.recycle.repository.OrderRepository;
import com.bupt.recycle.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @anthor tanshangou
 * @time 2018/5/26
 * @description
 */

@Slf4j
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    @Transactional
    public void createOrder(OrderModel orderModel) {

        Order order = new Order();
        BeanUtils.copyProperties(orderModel,order);
        List<OrderDetail> orderDetailList = orderModel.getOrderDetail();

        Order orderResult=orderRepository.save(order);
        for(OrderDetail orderDetail:orderDetailList){
            orderDetail.setOrderId(orderResult.getOrderId());
        }
        orderDetailRepository.saveAll(orderDetailList);
    }

    @Override
    public Object getAnOrder(int orderId) {
        Order order= orderRepository.findById(orderId).orElse(null);
        List<OrderDetail> orderDetailList=orderDetailRepository.findByOrderId(orderId);

        OrderModel orderModel = new OrderModel();
        //将需要返回的订单结果进行合并
        if(order!=null && orderDetailList!=null){
            BeanUtils.copyProperties(order,orderModel);
            orderModel.setOrderDetail(orderDetailList);
            return orderModel;
        }
        return null;
    }

    @Override
    public List<Order> getOrderList(String openId) {

        List<Order> orderList=orderRepository.findBySellerOpenid(openId);
        return orderList;
    }


}
