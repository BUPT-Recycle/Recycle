package com.bupt.recycle.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */

@Entity
@Table(name = "worker")
@DynamicUpdate
@Data
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long worker_id;

    @NotNull(message = "name cannot be null")
    private String worker_name;


    @NotNull(message = "password cannot be null")
    private String worker_password;


    @NotNull(message = "phone cannot be null")
    private String worker_tel;

    @NotNull(message = "area cannot be null")
    private String worker_area;


    private Double worker_star;

    @NotNull(message = "IDard cannot be null")
    private String worker_id_card;


}
