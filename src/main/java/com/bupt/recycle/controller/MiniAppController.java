package com.bupt.recycle.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.bupt.recycle.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @anthor tanshangou
 * @time 2018/5/20
 * @description
 */

@RestController
@RequestMapping("/mini")
@Slf4j
public class MiniAppController {

    @Autowired
    private WxMaService wxService;


    /**通过code+appid+appsecret获取openid和sessionkey等信息
     * 返回自定义登陆态
     * 仅在此步调用微信接口服务
     * @param code
     */
    @GetMapping("/auth")
    public String authorize(@RequestParam(name = "code")String code){

        log.info("获得code：{}",code);
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }
        try {
            WxMaJscode2SessionResult session = this.wxService.getUserService().getSessionInfo(code);
            log.info(session.getSessionKey());
            log.info(session.getOpenid());
            //TODO 可以增加自己的逻辑，关联业务相关数据
            return JsonUtils.toJson(session);
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
            return e.toString();
        }
    }

    
}
