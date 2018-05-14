package com.bupt.recycle.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * @anthor tanshangou
 * @time 2018/4/9
 * @description
 */

@Controller
public class UserController {

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal,Model model){
        model.addAttribute("username",principal.getName());
        return "user/user";
    }

}
