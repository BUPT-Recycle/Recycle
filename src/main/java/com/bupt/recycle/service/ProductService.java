package com.bupt.recycle.service;

import com.bupt.recycle.entity.Product;

import java.util.List;

/**
 * @anthor tanshangou
 * @time 2018/5/29
 * @description
 */
public interface ProductService {

    List<Product> getProductListByCategory(int categoryId);

    Object getAnProduct(int productId);

    List<Product> getProductList();
}
