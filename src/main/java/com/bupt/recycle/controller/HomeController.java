package com.bupt.recycle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

/**
 * @anthor tanshangou
 * @time 2018/4/9
 * @description
 */

@Controller
public class HomeController {

    @GetMapping({"/","/index","/home"})
    public String root(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
