package com.bupt.recycle.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */

@Entity
@Table(name="seller")
@Data
@DynamicUpdate
public class Seller {

    @Id
    private String seller_openid;

    private String seller_nickname;

    private String seller_tel;

    private String seller_addr;


}
