package com.bupt.recycle.service.impl;

import com.bupt.recycle.entity.Product;
import com.bupt.recycle.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @anthor tanshangou
 * @time 2018/5/29
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    public void getProductListByCategory() {

        List<Product> productList=productService.getProductListByCategory(1);
        Assert.assertNotNull(productList);
    }
}