/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.controller;

import com.bsptech.itcommunity.dao.SkillDataInter;
import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import com.bsptech.itcommunity.service.inter.LanguageServiceInter;
import com.bsptech.itcommunity.service.inter.SecurityServiceInter;
import com.bsptech.itcommunity.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author Goshgar
 */

@Controller
@RequestMapping(value = "/")
public class UserController {
	@Autowired
    private UserServiceInter userServiceInter;

	@Autowired
    private SecurityServiceInter securityServiceInter;

    @Autowired
    EmployeeProfileServiceInter employeeProfileServiceInter;

    @Autowired
    LanguageServiceInter languageServiceInter;

    @Autowired
    SkillDataInter skillDao;

    @Autowired
    EmployeeProfileServiceInter serviceInter;


    @Autowired
    private EmployeeController employeeController;

    @RequestMapping(path = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView register(@ModelAttribute(name = "employeeProfile") EmployeeProfile employeeProfile,
                                 ModelAndView modelAndView) {
        if(securityServiceInter.getLoggedInUserDetails()!=null){
            return employeeController.index(employeeProfile,modelAndView);
        }else{
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("index");
            return modelAndView;
        }
    }

    @PostMapping("/users")
    public ModelAndView registerUser(@ModelAttribute @Valid User user, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        if(result.hasErrors()) {
            return mv;
        }
        int r = userServiceInter.save(user);
        if(r==-1){
            result.rejectValue("email","email","already exists");
            return mv;
        }
        return new ModelAndView("redirect:/user/login?success=true");
    }

    @Autowired
    @Qualifier("pwdEncoder")
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/user/edit",method = RequestMethod.POST)
    public ModelAndView editPost(@ModelAttribute @Valid com.bsptech.itcommunity.bean.User user, BindingResult result) {
        if(result.hasErrors()) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("user/edit");
            return mv;
        }
        userServiceInter.update(user);
        return new ModelAndView("redirect:/user/edit?success");
    }

    @RequestMapping(path = "/user/edit")
    public ModelAndView edit(ModelAndView modelAndView) {
        User loggedInUser  = securityServiceInter.getLoggedInUserDetails().getUser();
        User user = userServiceInter.findById(loggedInUser.getId());
        user.setPassword(null);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user/edit");
        return modelAndView;
    }

    @RequestMapping(path = "/user/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("user/login");
        return modelAndView;
    }

    @GetMapping("/verify")
    public ModelAndView verifyEmail(ModelAndView modelAndView,
                                    @RequestParam(name = "email") String email,
                                    @RequestParam(name = "code") Integer code){

        User user = userServiceInter.findByEmail(email);

        if(user.getVerifyEmailCode().equals(code)){
            user.setEnabled(true);
            userServiceInter.save(user);
            modelAndView.setViewName("index");
        } else {
            modelAndView.setViewName("index");
        }

        return modelAndView;
    }

}
