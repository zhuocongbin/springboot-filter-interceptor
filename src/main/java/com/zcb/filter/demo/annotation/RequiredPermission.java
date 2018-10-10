package com.zcb.filter.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by zhuocongbin
 * date 2018/10/10
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequiredPermission {
    String value();
}
