package com.bupt.recycle.repository;

import com.bupt.recycle.entity.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @anthor tanshangou
 * @time 2018/5/27
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)

public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void saveOrder(){
        Order order = new Order();
        order.setOrderAmount(10.0);
        order.setPayState(0);
        order.setSellerAddr("北京邮电大学");
        order.setSellerName("婷婷");
        order.setWorkerArea("HK");
        order.setSellerTel("13011816363");
        order.setSellerOpenid("oFjvM4gOI5QOniikVlEiCk52NqxY");
        order.setWorkerId(7);
        orderRepository.save(order);
    }

    @Test
    public void getOrderList(){
        List<Order> orderList=orderRepository.findBySellerOpenid("oFjvM4gOI5QOniikVlEiCk52NqxY");

        Assert.assertNotNull(orderList);
    }
}