package com.bupt.recycle.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.bupt.recycle.service.SellerService;
import com.bupt.recycle.utils.JsonUtils;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @anthor tanshangou
 * @time 2018/5/24
 * @description
 */

@Slf4j
@RestController
@RequestMapping("/mini/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private WxMaService wxService;


    @PostMapping("/addrandphone")
    public String saveExtraInfo(@RequestParam(name = "address") String address,
                                @RequestParam(name = "phone") String phone,
                                @RequestParam(name="rsession") String rsession){

        WxMaJscode2SessionResult result=(WxMaJscode2SessionResult)redisTemplate.opsForValue().get(rsession);
        String openid=result.getOpenid();
        log.info("for user openid:{},address:{}, phone:{}",openid,address,phone);

        sellerService.setExtraInfo(address,phone,openid);
        return "success";
    }

}
