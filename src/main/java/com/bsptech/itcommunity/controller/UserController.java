/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Goshgar
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(path = "/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName("user/registration");
        return modelAndView;
    }

    @RequestMapping(path = "/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("user/login");
        return modelAndView;
    }
}
