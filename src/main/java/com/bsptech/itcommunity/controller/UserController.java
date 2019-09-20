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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute User user,ModelAndView modelAndView) {
        User user1=userServiceInter.update(user);
       // modelAndView.addObject("user",user1);
        modelAndView.setViewName("user/edit?success");
        return modelAndView;
    }

    @RequestMapping(path = "/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("user/login");
        return modelAndView;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView registerPost(ModelAndView modelAndView, @ModelAttribute @Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("user/registration");
            return mv;
        }
        User u = userServiceInter.save(user);
          return new ModelAndView("redirect:/user/login?success=true");
    }

}
