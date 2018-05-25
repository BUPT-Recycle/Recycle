package com.bupt.recycle.repository;

import com.bupt.recycle.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */

@Repository
public interface SellerRepository extends JpaRepository<Seller,String> {


    @Transactional
    @Modifying
    @Query("update Seller s set s.seller_addr=?1,s.seller_tel=?2 where s.seller_openid=?3")
    int setSellerAddrAndPhone(String address,String phone,String openid);


}
