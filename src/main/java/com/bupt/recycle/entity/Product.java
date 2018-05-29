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
@Table(name="product")
@Data
@DynamicUpdate
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String product_name;
    private String product_description;
    private String product_stock;
    private String product_price;
    @Column(name = "category_id")
    private int categoryId;

}
