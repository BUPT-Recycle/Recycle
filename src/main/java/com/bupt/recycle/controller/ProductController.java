package com.bupt.recycle.controller;

import com.bupt.recycle.entity.Category;
import com.bupt.recycle.entity.Product;
import com.bupt.recycle.service.CategoryService;
import com.bupt.recycle.service.ProductService;
import com.bupt.recycle.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @anthor tanshangou
 * @time 2018/5/29
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/mini")
public class ProductController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable(name = "id") int productId){
        Product product = (Product) productService.getAnProduct(productId);
        return JsonUtils.toJson(product);
    }

    @GetMapping("/product")
    public String getProductList(){
        List<Product> productList = productService.getProductList();
        return JsonUtils.toJson(productList);
    }
    @GetMapping("/category/{id}")
    public String getProductList(@PathVariable(name = "id")int categoryId){
        List<Product> productList = productService.getProductListByCategory(categoryId);
        return JsonUtils.toJson(productList);
    }

    @GetMapping("/category")
    public String getCategoryList(){
        List<Category> categoryList = categoryService.getCategoryList();
        return JsonUtils.toJson(categoryList);
    }

}
