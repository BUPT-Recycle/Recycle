package com.bupt.recycle.repository;

import com.bupt.recycle.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @anthor tanshangou
 * @time 2018/5/26
 * @description
 */
public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findBySellerOpenid(String openId);

    List<Order> findByPayState(int payState);


    @Transactional
    @Modifying
    @Query("update Order o set o.payState =?1 where o.orderId=?2")
    int setPayState(int pay_state,int orderId);
}
