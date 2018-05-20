package com.bupt.recycle.repository;

import com.bupt.recycle.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @anthor tanshangou
 * @time 2018/5/20
 * @description
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}
