package com.bupt.recycle.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @anthor tanshangou
 * @time 2018/5/20
 * @description
 */

@Entity
@Table(name="order")
@Data
@DynamicUpdate
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    private String seller_openid;

    private String seller_name;

    private String seller_tel;

    private String seller_addr;

    private Long worker_id;

    private String worker_area;

    private int pay_state;

    private Double order_amount;


}
