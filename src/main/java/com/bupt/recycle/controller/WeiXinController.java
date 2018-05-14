package com.bupt.recycle.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @anthor tanshangou
 * @time 2018/5/8
 * @description
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeiXinController {

    @GetMapping("/auth")
    public void auth(@RequestParam(name = "code") String code){
        log.info("进入验证");
        log.info("code: "+code);

        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx05799f115ff77cec&secret=3df4cc7b7194ae72a02f24d00f833def&code="+code+"&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();
        String access_code=restTemplate.getForObject(url,String.class);

        log.info("access_code:"+access_code);
    }
}
