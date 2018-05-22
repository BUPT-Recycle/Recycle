package com.bupt.recycle.service;

import com.bupt.recycle.entity.Seller;
import com.bupt.recycle.repository.SellerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @anthor tanshangou
 * @time 2018/5/23
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class SellerServiceTest {

    @Autowired
    SellerRepository sellerRepository;

    @Test
    public void saveSeller() {
        Seller seller = new Seller();
        seller.setSeller_openid("123445");
        seller.setSeller_nickname("薛定谔的\uD83D\uDC36");
        sellerRepository.save(seller);
    }

    @Test
    public void getSeller() {
    }
}