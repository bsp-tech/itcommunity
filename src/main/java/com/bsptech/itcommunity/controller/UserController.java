/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.entity.UserRole;
import com.bsptech.itcommunity.service.inter.GenderServiceInter;
import com.bsptech.itcommunity.service.inter.ItProjectServiceInter;
import com.bsptech.itcommunity.service.inter.RoleServiceInter;
import com.bsptech.itcommunity.service.inter.UserRoleServiceInter;
import com.bsptech.itcommunity.service.inter.UserServiceInter;

/**
 * @author Goshgar
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
    private UserRoleServiceInter userRoleServiceInter;
	@Autowired
    private UserServiceInter userServiceInter;
	@Autowired
    private RoleServiceInter roleServiceInter;
	@Autowired
    private GenderServiceInter genderServiceInter;
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

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerPost(ModelAndView modelAndView,@ModelAttribute User user,RedirectAttributes redirectAttributes) {
    	user.setInsertDateTime(new java.sql.Date(new Date().getTime()));
    	User u = userServiceInter.save(user);
    	if(u!=null) {
    		UserRole userRole = new UserRole(u,roleServiceInter.findById(2));
    		userRole.setInsertDateTime(new java.sql.Date(new Date().getTime()));
    		userRoleServiceInter.save(userRole);
    		return "redirect:/user/login?success=true";
    	}
    	//Throw Exception
		return "redirect:/user/register";
    }
}
