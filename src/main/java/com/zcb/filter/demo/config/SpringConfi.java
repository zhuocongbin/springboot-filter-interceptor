package com.zcb.filter.demo.config;

import com.zcb.filter.demo.interceptor.BasicInterceptorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by zhuocongbin
 * date 2018/10/10
 */
@Configuration
public class SpringConfi implements WebMvcConfigurer{
    @Bean
    public BasicInterceptorHandler basicInterceptorHandler() {
        return new BasicInterceptorHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(basicInterceptorHandler()).excludePathPatterns("/static/*")
                .excludePathPatterns("/error").addPathPatterns("/**");
    }
}
