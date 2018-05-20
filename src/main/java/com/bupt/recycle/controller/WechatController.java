package com.bupt.recycle.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;
import java.net.URLEncoder;

/**
 * @anthor tanshangou
 * @time 2018/5/11
 * @description
 */

@Slf4j
@Controller
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    WxMpService wxMpService;


    @GetMapping("/authorize")
    public String authorize(@RequestParam(name = "returnUrl") String returnUrl) {

        //1. 配置

        //2. 调用方法
        String url = "http://bupt-recycle.mynatapp.cc/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        log.info("微信网页授权获取code，redirectUrl={}", redirectUrl);

        return "redirect:" + redirectUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {

        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("微信网页授权错误：{}", e);
        }
        String openid = wxMpOAuth2AccessToken.getOpenId();

        log.info("微信网页跳转获取openid={}", openid);

        return "redirect:" + returnUrl + "?openid=" + openid;

    }
}