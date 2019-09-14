package com.bsptech.itcommunity.controller;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import com.bsptech.itcommunity.service.inter.LanguageServiceInter;
import com.bsptech.itcommunity.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
public class EmployeeController {

	@Autowired
	EmployeeProfileServiceInter employeeProfileServiceInter;

	@Autowired
	LanguageServiceInter languageServiceInter;

	@Autowired
	SkillServiceInter skillServiceInter;

    @Autowired
    EmployeeProfileServiceInter serviceInter;

    @GetMapping(path = "/")
    public ModelAndView index(
            @PathVariable(name = "page", required = false) String pageS,
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "surname", required = false, defaultValue = "") String surname,
            @RequestParam(name = "mail", required = false, defaultValue = "") String mail,
            @RequestParam(name = "number", required = false, defaultValue = "") String number,
            ModelAndView modelAndView
            ){

        List<EmployeeProfile> list = serviceInter.findAll();

        modelAndView.addObject("pages", 10);
        modelAndView.addObject("page", 1);
        modelAndView.addObject("employeeList", list);
        modelAndView.addObject("pagination", false);

        modelAndView.setViewName("employee/index");
        return modelAndView;
    }

    @RequestMapping(path = "/employees/{employeeId}")
    public ModelAndView detail(@PathVariable("employeeId") Integer employeeId, ModelAndView modelAndView) {
        modelAndView.setViewName("employee/details");
        return modelAndView;
    }

    @RequestMapping(path = "/employees/register")
    public ModelAndView register(ModelAndView modelAndView, Model model) {
        modelAndView.addObject("employeeProfile",new EmployeeProfile());
    	modelAndView.addObject("listLanguages",languageServiceInter.findAll());
    	modelAndView.addObject("listSkills",skillServiceInter.findAll());
        modelAndView.setViewName("employee/registration");
        return modelAndView;
    }

    @RequestMapping(value = "/employees/register",method=RequestMethod.POST)
    public ModelAndView register(
                ModelAndView modelAndView,
                @Valid @ModelAttribute("employeeProfile") EmployeeProfile employeeProfile,
                BindingResult result,
                HttpSession session) {
//        if(result.hasErrors()) {
//        	modelAndView.setViewName("employee/registration");
//        	return modelAndView;
//        }
        System.out.println(employeeProfile);
        System.out.println(employeeProfile.getEmployeeProfileLanguageList());//
    	EmployeeProfile ep = employeeProfileServiceInter.register(employeeProfile);
        modelAndView.setViewName("employee/index");
    	return modelAndView;
    }

}
