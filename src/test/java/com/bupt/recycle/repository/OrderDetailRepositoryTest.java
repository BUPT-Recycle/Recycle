package com.bupt.recycle.repository;

import com.bupt.recycle.entity.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @anthor tanshangou
 * @time 2018/5/27
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class OrderDetailRepositoryTest {
    @Autowired
    OrderDetailRepository orderDetailRepository;


    @Test
    public void saveOrderDetail(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(1);
        orderDetail.setProduct_name("PET");
        orderDetail.setProduct_price(5.0);
        orderDetail.setProduct_quantity(4);
        orderDetailRepository.save(orderDetail);
    }

    @Test
    public void findByOrderId() {

    }
}