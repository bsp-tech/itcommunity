package com.bsptech.itcommunity.controller;

import com.bsptech.itcommunity.entity.*;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeProfileServiceInter employeeProfileServiceInter;

    @GetMapping(value = {"", "/{page}"})
    public ModelAndView index(
            @PathVariable(name = "page", required = false) Integer page,
            @ModelAttribute(name = "employeeProfile") EmployeeProfile employeeProfile,
            ModelAndView modelAndView
            ) {

        modelAndView.addObject("employeeProfile", new EmployeeProfile());
        //DEBUG
        List<Language> languagesDb = new ArrayList<>();
        languagesDb.add(new Language(1, "Azerbaijani"));
        languagesDb.add(new Language(2, "Turkish"));
        languagesDb.add(new Language(3, "English"));
        languagesDb.add(new Language(4, "Russian"));


        List<Skill> skillsDb = new ArrayList<>();
        skillsDb.add(new Skill(1, "Java"));
        skillsDb.add(new Skill(2, "C++"));
        skillsDb.add(new Skill(3, "Python"));
        skillsDb.add(new Skill(4, "Ruby"));

        System.out.println(employeeProfile);
//        List<EmployeeProfile>   employeeProfileList = employeeProfileServiceInter.findAll(employeeProfile.get,surname,mail,phone);
//
//        modelAndView.addObject("employeeList", employeeProfileList);
        modelAndView.addObject("languages", languagesDb);
        modelAndView.addObject("skills", skillsDb);
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
