package com.zcb.filter.demo.controller;

import com.zcb.filter.demo.annotation.RequiredPermission;
import com.zcb.filter.demo.constant.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhuocongbin
 * date 2018/10/10
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @RequestMapping("/list")
    @RequiredPermission(Constants.ADMIN_PRODUCT_LIST)
    public String list() {
        // 省略产品列表查询逻辑
        System.out.println("/product/list");
        return "/product/list";
    }
}
