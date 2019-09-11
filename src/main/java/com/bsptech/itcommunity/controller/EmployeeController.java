package com.bsptech.itcommunity.controller;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.Language;
import com.bsptech.itcommunity.entity.Skill;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import com.bsptech.itcommunity.service.inter.LanguageServiceInter;
import com.bsptech.itcommunity.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeProfileServiceInter employeeProfileServiceInter;
    
    @Autowired
    private LanguageServiceInter languageServiceInter;
    
    @Autowired
    private SkillServiceInter skillServiceInter;

    @GetMapping(value = {"", "/{page}"})
    public ModelAndView index(
            @PathVariable(name = "page", required = false) Integer page,
            @ModelAttribute(name = "employeeProfile") EmployeeProfile employeeProfile,
            ModelAndView modelAndView
            ){

        modelAndView.addObject("employeeProfile", new EmployeeProfile());
        
        List<Language> languages = languageServiceInter.findAll();
        List<Skill> skills = skillServiceInter.findAll();

        List<EmployeeProfile> employeeProfileList = employeeProfileServiceInter.findAll(employeeProfile);
        
        System.out.println(employeeProfile.getEmployeeProfileLanguageList()+"\n"+employeeProfile.getEmployeeProfileSkillList());
        
        
        modelAndView.addObject("employeeList", employeeProfileList);
        modelAndView.addObject("languages", languages);
        modelAndView.addObject("skills", skills);
        modelAndView.setViewName("employee/index");

        return modelAndView;
    }

    @RequestMapping(path = "/employees/{employeeId}")
    public ModelAndView detail(@PathVariable("employeeId") Integer employeeId, ModelAndView modelAndView) {
        modelAndView.setViewName("employee/details");
        return modelAndView;
    }

    @RequestMapping(path = "/employees/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName("employee/registration");
        return modelAndView;
    }

}
