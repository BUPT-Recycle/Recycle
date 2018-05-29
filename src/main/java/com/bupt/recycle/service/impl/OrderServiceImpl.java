package com.bupt.recycle.service.impl;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.bupt.recycle.entity.Order;
import com.bupt.recycle.entity.OrderDetail;
import com.bupt.recycle.entity.Worker;
import com.bupt.recycle.model.OrderModel;
import com.bupt.recycle.repository.OrderDetailRepository;
import com.bupt.recycle.repository.OrderRepository;
import com.bupt.recycle.repository.WorkerRepository;
import com.bupt.recycle.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Override
    @Transactional
    public Order createOrder(OrderModel orderModel) {

        Order order = new Order();
        BeanUtils.copyProperties(orderModel,order);
        WxMaJscode2SessionResult wxMaJscode2SessionResult=
                (WxMaJscode2SessionResult) redisTemplate.opsForValue().get(orderModel.getRsession());
        order.setSellerOpenid(wxMaJscode2SessionResult.getOpenid());
        order.setWorkerId(7);
        Worker worker = workerRepository.findById(order.getWorkerId()).orElse(null);
        order.setWorkerArea(worker.getWorker_area());
        List<OrderDetail> orderDetailList = orderModel.getOrderDetail();

        Order orderResult=orderRepository.save(order);
        for(OrderDetail orderDetail:orderDetailList){
            orderDetail.setOrderId(orderResult.getOrderId());
        }
        orderDetailRepository.saveAll(orderDetailList);
        return orderResult;
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
