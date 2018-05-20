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
@Table(name="category")
@Data
@DynamicUpdate
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    private String category_name;


}
