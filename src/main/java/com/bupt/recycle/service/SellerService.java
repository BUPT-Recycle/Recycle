package com.bupt.recycle.service;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */
public interface SellerService {

    //保存openid
    void saveOpenId(String openid);

    //根据openid返回Seller实例
    void getSeller(String openid);

}
