package com.zcb.filter.demo.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhuocongbin
 * date 2018/10/10
 */
@RestController
public class Test {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String get(HttpServletRequest request) {
        System.out.println(request.getParameter("test"));
        return "test";
    }

    @RequestMapping(value = "/hello/test", method = RequestMethod.GET)
    public String helloget(HttpServletRequest request) {
        System.out.println(request.getParameter("test"));
        return "test";
    }
}
