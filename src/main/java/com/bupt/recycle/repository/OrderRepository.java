package com.bupt.recycle.repository;

import com.bupt.recycle.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @anthor tanshangou
 * @time 2018/5/26
 * @description
 */
public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findBySellerOpenid(String openId);
}
