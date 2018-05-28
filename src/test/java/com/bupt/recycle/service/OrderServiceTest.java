package com.bupt.recycle.service;

import com.bupt.recycle.entity.Order;
import com.bupt.recycle.entity.OrderDetail;
import com.bupt.recycle.model.OrderModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @anthor tanshangou
 * @time 2018/5/27
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void createOrder() {
        OrderModel orderModel = new OrderModel();
        Order order = new Order();
        order.setOrderAmount(27.1);
        order.setPayState(0);
        order.setSellerAddr("北京邮电大学");
        order.setSellerName("婷婷");
        order.setWorkerArea("HK");
        order.setSellerTel("13011816363");
        order.setSellerOpenid("oFjvM4gOI5QOniikVlEiCk52NqxY");
        order.setWorkerId(7);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct_name("PET");
        orderDetail.setProduct_price(5.0);
        orderDetail.setProduct_quantity(4);
        orderDetailList.add(orderDetail);
        orderDetail.setProduct_name("PVC");
        orderDetail.setProduct_price(3.55);
        orderDetail.setProduct_quantity(2);
        orderDetailList.add(orderDetail);
        BeanUtils.copyProperties(order,orderModel);
        orderModel.setOrderDetail(orderDetailList);
        orderService.createOrder(orderModel);
    }

    @Test
    public void getAnOrder() {
    }

    @Test
    public void getOrderList() {
    }
}