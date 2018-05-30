package com.bupt.recycle.controller;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.bupt.recycle.entity.Order;
import com.bupt.recycle.model.OrderModel;
import com.bupt.recycle.service.OrderService;
import com.bupt.recycle.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @anthor tanshangou
 * @time 2018/5/26
 * @description
 */

@RequestMapping("/mini")
@RestController
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @GetMapping("/order")
    public String getOrderList(@RequestParam("rsession") String rsession){

        WxMaJscode2SessionResult sessionResult = (WxMaJscode2SessionResult) redisTemplate.opsForValue().get(rsession);
        List<Order> orderList;
        orderList=orderService.getOrderList(sessionResult.getOpenid());
        //orderList=orderService.getOrderList(rsession);
        return JsonUtils.toJson(orderList);
    }

    @GetMapping("/order/{orderId}")
    public String getOrder(@PathVariable("orderId") int orderId){
        OrderModel orderModel = (OrderModel) orderService.getAnOrder(orderId);
        if(orderModel!=null){
            return JsonUtils.toJson(orderModel);
        }
        return null;
    }

    @PostMapping("/order")
    public String saveOrder(@RequestBody OrderModel orderModel){
        Order order = orderService.createOrder(orderModel);
        return JsonUtils.toJson(order);
    }

    @PostMapping("/order/payState")
    public String changeState(@RequestParam (name = "payState")int payState,
                              @RequestParam(name = "orderId")int orderId){

        int result=orderService.updatePayState(payState,orderId);
        return String.valueOf(result);
    }

    @GetMapping("/order/payState/{payState}")
    public String getOrderListByState(@PathVariable(name = "payState") int payState,
                                      @RequestParam(name = "rsession") String rsession){

        List<Order> orderList=orderService.getOrderListByState(payState,rsession);

        return JsonUtils.toJson(orderList);
    }
}
