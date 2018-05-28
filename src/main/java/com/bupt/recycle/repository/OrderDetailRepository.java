package com.bupt.recycle.repository;

import com.bupt.recycle.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @anthor tanshangou
 * @time 2018/5/26
 * @description
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {


    List<OrderDetail> findByOrderId(int orderId);
}
