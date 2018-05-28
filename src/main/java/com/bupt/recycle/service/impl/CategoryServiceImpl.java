package com.bupt.recycle.service.impl;

import com.bupt.recycle.entity.Category;
import com.bupt.recycle.repository.CategoryRepository;
import com.bupt.recycle.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @anthor tanshangou
 * @time 2018/5/26
 * @description
 */

@Slf4j
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}
