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
@Table(name="order_detail")
@Data
@DynamicUpdate
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detail_id;

    private Long order_id;

    private Long product_id;

    private String product_name;

    private Double product_price;

    private int product_quantity;

}
