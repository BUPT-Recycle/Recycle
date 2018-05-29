package com.bupt.recycle.service.impl;

import com.bupt.recycle.entity.Product;
import com.bupt.recycle.repository.ProductRepository;
import com.bupt.recycle.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @anthor tanshangou
 * @time 2018/5/29
 * @description
 */

@Slf4j
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProductListByCategory(int categoryId) {

        List<Product> productList=productRepository.findAllByCategoryId(categoryId);
        return productList;
    }

    @Override
    public Object getAnProduct(int productId) {
        Product product = productRepository.findById(productId).orElse(null);
        return product;
    }

    @Override
    public List<Product> getProductList() {

        return productRepository.findAll();
    }
}
