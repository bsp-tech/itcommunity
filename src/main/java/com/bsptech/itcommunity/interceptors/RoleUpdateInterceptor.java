package com.bsptech.itcommunity.interceptors;

import com.bsptech.itcommunity.service.inter.SecurityServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RoleUpdateInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SecurityServiceInter securityService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        securityService.reloadRoles();
        return true;
    }
}
