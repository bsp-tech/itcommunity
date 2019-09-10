/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.controller;

import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.service.inter.UserServiceInter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Goshgar
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
    private UserServiceInter userServiceInter;

    @RequestMapping(path = "/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("user/registration");
        return modelAndView;
    }

    @RequestMapping(path = "/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("user/login");
        return modelAndView;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerPost(ModelAndView modelAndView, @ModelAttribute User user,RedirectAttributes redirectAttributes,HttpSession session) {
    	User u = userServiceInter.save(user);
    	if(u!=null) {
    		return "redirect:/user/login?success=true";
    	}
		return "redirect:/user/register";
    }
}
