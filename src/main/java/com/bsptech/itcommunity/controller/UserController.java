/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.controller;

import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.service.inter.SecurityServiceInter;
import com.bsptech.itcommunity.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Goshgar
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
    private UserServiceInter userServiceInter;

	@Autowired
    private SecurityServiceInter securityServiceInter;

    @RequestMapping(path = "/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("user/registration");
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

    @RequestMapping(path = "/edit")
    public ModelAndView edit(ModelAndView modelAndView) {
        User loggedInUser  = securityServiceInter.getLoggedInUserDetails().getUser();
        System.out.println("loggedInUser="+loggedInUser);
        modelAndView.addObject("user", loggedInUser);
        modelAndView.setViewName("user/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String editPost(@ModelAttribute User user) {
        User u = userServiceInter.save(user);
        if(u!=null) {
            return "redirect:/";
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("user/login");
        return modelAndView;
    }


}
