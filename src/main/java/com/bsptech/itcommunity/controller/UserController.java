/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.controller;

import com.bsptech.itcommunity.dao.SkillDataInter;
import com.bsptech.itcommunity.dao.UserDataInter;
import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.service.inter.*;
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
    MailServiceInter mailServiceInter;

    @Autowired
    UserDataInter userDataInter;

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

    @GetMapping("/forgot")
    public ModelAndView forgot(ModelAndView modelAndView){
        modelAndView.setViewName("/forgot");
        return modelAndView;
    }

    @GetMapping("/send")
    public ModelAndView send(ModelAndView modelAndView,
                            @RequestParam(name = "email") String email){

        User user = userServiceInter.findByEmail(email);

        if(user != null){
            user.setResetPasswordCode((int)(Math.random()*((10000-1000))+1000));
            userDataInter.save(user);
            mailServiceInter.sendResetCode(email,user.getResetPasswordCode());
        }

        modelAndView.setViewName("/");

        return modelAndView;
    }

    @GetMapping("/reset")
    public ModelAndView reset(ModelAndView modelAndView,
                              @RequestParam(name = "email") String email,
                              @RequestParam(name = "code") int code){

        User user = userServiceInter.findByEmail(email);

        if(user!=null && user.getResetPasswordCode().equals(code)){
            modelAndView.addObject("user",user); // email ekranda gostermek uchun
            modelAndView.setViewName("/reset");
        }

        return modelAndView;
    }

    @PostMapping("/reset")
    public ModelAndView reset(ModelAndView modelAndView,String email, String newPassword){
        User user = userServiceInter.findByEmail(email);

        user.setPassword(passwordEncoder.encode(newPassword));

        userDataInter.save(user);

        modelAndView.setViewName("/");
        return modelAndView;
    }


}
