package com.bupt.recycle.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */
@RestController
public class HttpErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    /**
     * Supports the HTML Error View
     *
     * @param request
     * @return
     */
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorHtml(HttpServletRequest request) {
        return "404";
    }

    /**
     * Supports other formats like JSON, XML
     *
     * @param request
     * @return
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public Object error(HttpServletRequest request) {
        return "404";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
