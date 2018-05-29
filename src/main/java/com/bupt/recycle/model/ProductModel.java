package com.bupt.recycle.model;

import com.bupt.recycle.entity.Product;
import lombok.Data;

import java.util.List;

/**
 * @anthor tanshangou
 * @time 2018/5/29
 * @description
 */
@Data
public class ProductModel {

    private int categoryId;
    private String categoryName;
    private List<Product> productList;
}
