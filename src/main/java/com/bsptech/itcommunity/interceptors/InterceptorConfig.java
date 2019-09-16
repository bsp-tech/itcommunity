package com.bsptech.itcommunity.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    RoleUpdateInterceptor  interceptor;

    @Override
    public void addInterceptors (InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(interceptor).addPathPatterns("/**");
    }
}
