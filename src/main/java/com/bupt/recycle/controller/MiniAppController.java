package com.bupt.recycle.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.bupt.recycle.entity.Seller;
import com.bupt.recycle.service.SellerService;
import com.bupt.recycle.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @anthor tanshangou
 * @time 2018/5/20
 * @description
 */

@RestController
@RequestMapping("/mini/user")
@Slf4j
public class MiniAppController {

    @Autowired
    private WxMaService wxService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    /**通过code+appid+appsecret获取openid和sessionkey等信息
     * 返回自定义登陆态
     * @param code
     */
    @GetMapping("/login")
    public String login(@RequestParam(name = "code")String code){

        log.info("获得code：{}",code);
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }
        try {
            //获取sessionKey+openid
            WxMaJscode2SessionResult session = this.wxService.getUserService().getSessionInfo(code);
            String sessionKey=session.getSessionKey();
            String openId= session.getOpenid();
            log.info(sessionKey);
            log.info(session.getOpenid());
            //查询openid是否已经存在以确定是否需要入库(mysql)

            //key:rsession=openid+session,value:session(object)加入内存
            String rsession=sessionKey+openId;

            //如果存在旧登录态
            if(redisTemplate.hasKey(openId)) {
                String oldRsession=redisTemplate.opsForValue().get(openId).toString();
                redisTemplate.delete(openId);
                redisTemplate.delete(oldRsession);
            }
            redisTemplate.opsForValue().set(rsession,session,30,TimeUnit.DAYS);
            redisTemplate.opsForValue().set(openId,rsession);
            return rsession;
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
            return e.toString();
        }
    }

    //授权的同时进行入库
    @PostMapping("/info")
    public String info(@RequestParam(name = "rsession") String rsession, @RequestParam(name = "signature")String signature,
                       @RequestParam(name = "rawData")String rawData, @RequestParam(name = "encryptedData")String encryptedData,
                       @RequestParam(name = "iv")String iv) {

        WxMaJscode2SessionResult session=(WxMaJscode2SessionResult) redisTemplate.opsForValue().get(rsession);

        // 用户信息校验
        if (!this.wxService.getUserService().checkUserInfo(session.getSessionKey(), rawData, signature)) {
            return "user check failed";
        }

        // 解密用户信息
        //TODO 需要判断库内是否已经存在（表不设置unique key）
        WxMaUserInfo userInfo = this.wxService.getUserService().getUserInfo(session.getSessionKey(), encryptedData, iv);
        log.info(JsonUtils.toJson(userInfo));
        Seller seller = new Seller();
        seller.setSeller_openid(userInfo.getOpenId());
        seller.setAvatarUrl(userInfo.getAvatarUrl());

        seller.setSeller_nickname(userInfo.getNickName());

        sellerService.saveSeller(seller);

        return "success";
    }


    //暂时不适用，需要权限
    @GetMapping("/phone")
    public String phone(@RequestParam(name = "rsession") String rsession, @RequestParam(name = "signature")String signature,
                        @RequestParam(name = "rawData")String rawData, @RequestParam(name = "encryptedData")String encryptedData,
                        @RequestParam(name = "iv")String iv) {
        WxMaJscode2SessionResult session=(WxMaJscode2SessionResult) redisTemplate.opsForValue().get(rsession);

        // 用户信息校验
        if (!this.wxService.getUserService().checkUserInfo(session.getSessionKey(), rawData, signature)) {
            return "user check failed";
        }

        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = this.wxService.getUserService().getPhoneNoInfo(session.getSessionKey(), encryptedData, iv);

        return JsonUtils.toJson(phoneNoInfo);
    }


}
