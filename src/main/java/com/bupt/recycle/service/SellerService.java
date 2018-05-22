package com.bupt.recycle.service;

import com.bupt.recycle.entity.Seller;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */
public interface SellerService {

    //保存openid
    void saveSeller(Seller seller);

    //根据openid返回Seller实例
    void getSeller(String openid);

}
