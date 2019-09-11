/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.security;

import com.bsptech.itcommunity.dao.UserDataInter;
import com.bsptech.itcommunity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author sarkhanrasullu
 */
@Component
public class SecurityUtil {

    @Autowired
    private UserDataInter userRepo;

    public boolean hasAuthority(String authority) {
        return true;
//        return loggedInUser().getRoleId().getName().equals(authority.toUpperCase());
    }

    public User loggedInUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null) {
//            return null;
//        }//org.springframework.security.oauth2.provider.OAuth2Authentication
//
////        OAuth2Authentication auth = (OAuth2Authentication) authentication;
//        UserProjection user = userRepo.getByEmail(authentication.getPrincipal().toString());
//        return user;

        return new User(1);
    }

//    public static String logout(HttpServletRequest request, HttpServletResponse response) {
//        CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);
//        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
//        cookieClearingLogoutHandler.logout(request, response, null);
//        securityContextLogoutHandler.logout(request, response, null);
//
//        return "redirect:/login";
//    }
}
