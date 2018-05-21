package com.bupt.recycle.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.bupt.recycle.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            log.info(sessionKey);
            log.info(session.getOpenid());
            //查询openid是否已经存在以确定是否需要入库

            //根据rsession=openid+session加入内存

            return JsonUtils.toJson(session);
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
            return e.toString();
        }
    }

    @GetMapping("/info")
    public String info(@RequestParam(name = "sessionKey") String sessionKey, @RequestParam(name = "signature")String signature,
                       @RequestParam(name = "rawData")String rawData, @RequestParam(name = "encryptedData")String encryptedData,
                       @RequestParam(name = "iv")String iv) {
        // 用户信息校验
        if (!this.wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return "user check failed";
        }

        // 解密用户信息
        WxMaUserInfo userInfo = this.wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);
        return JsonUtils.toJson(userInfo);
    }

    @GetMapping("/phone")
    public String phone(@RequestParam(name = "sessionKey") String sessionKey, @RequestParam(name = "signature")String signature,
                        @RequestParam(name = "rawData")String rawData, @RequestParam(name = "encryptedData")String encryptedData,
                        @RequestParam(name = "iv")String iv) {
        // 用户信息校验
        if (!this.wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return "user check failed";
        }

        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = this.wxService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);

        return JsonUtils.toJson(phoneNoInfo);
    }


}
