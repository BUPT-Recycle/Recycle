package com.bupt.recycle.service.impl;

import com.bupt.recycle.repository.SellerRepository;
import com.bupt.recycle.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public void saveOpenId(String openid) {

    }

    @Override
    public void getSeller(String openid) {

    }
}
