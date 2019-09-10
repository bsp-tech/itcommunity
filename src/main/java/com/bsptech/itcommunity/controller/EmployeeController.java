package com.bsptech.itcommunity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import com.bsptech.itcommunity.service.inter.LanguageServiceInter;
import com.bsptech.itcommunity.service.inter.SkillServiceInter;

@Controller
@RequestMapping
public class EmployeeController {
	@Autowired
	EmployeeProfileServiceInter employeeProfileServiceInter;
	@Autowired
	LanguageServiceInter languageServiceInter;
	@Autowired
	SkillServiceInter skillServiceInter;
    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("employee/index");
        return modelAndView;
    }

    @RequestMapping(path = "/employees/{employeeId}")
    public ModelAndView detail(@PathVariable("employeeId") Integer employeeId, ModelAndView modelAndView) {
        modelAndView.setViewName("employee/details");
        return modelAndView;
    }

    @RequestMapping(path = "/employees/register")
    public ModelAndView register(ModelAndView modelAndView,Model model) {
    	modelAndView.addObject("employeeProfile",new EmployeeProfile());
    	modelAndView.addObject("listLanguages",languageServiceInter.findAll());
    	modelAndView.addObject("listSkills",skillServiceInter.findAll());
        modelAndView.setViewName("employee/registration");
        System.out.println(modelAndView);
        return modelAndView;
    }
    @RequestMapping(value = "/employees/register",method=RequestMethod.POST)
    public ModelAndView register(ModelAndView modelAndView,@Valid @ModelAttribute("employeeProfile") EmployeeProfile employeeProfile,BindingResult result
    		,HttpSession session) {
    	System.out.println(employeeProfile);
        if(result.hasErrors()) {
        	modelAndView.setViewName("employee/registration");
        	return modelAndView;
        }
        System.out.println(employeeProfile);
    	EmployeeProfile ep = employeeProfileServiceInter.save(employeeProfile,session);
        modelAndView.setViewName("employee/index");
    	return modelAndView;
    }

}
