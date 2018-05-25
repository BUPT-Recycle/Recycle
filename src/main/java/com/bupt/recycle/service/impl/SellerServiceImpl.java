package com.bupt.recycle.service.impl;

import com.bupt.recycle.entity.Seller;
import com.bupt.recycle.repository.SellerRepository;
import com.bupt.recycle.service.SellerService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    public void saveSeller(Seller seller) {
        sellerRepository.save(seller);
    }

    @Override
    public Object getSeller(String openid) {

        Optional<Seller> sellerOptional=sellerRepository.findById(openid);
        return sellerOptional.orElse(null);
    }

    @Override
    public int setExtraInfo(String address, String phone, String openid) {

        return sellerRepository.setSellerAddrAndPhone(address,phone,openid);
    }
}
