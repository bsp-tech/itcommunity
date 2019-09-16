package com.bsptech.itcommunity.controller;

import com.bsptech.itcommunity.dao.SkillDataInter;
import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.service.impl.SecurityServiceImpl;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import com.bsptech.itcommunity.service.inter.LanguageServiceInter;
import com.bsptech.itcommunity.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    SkillDataInter skillDao;

    @Autowired
    EmployeeProfileServiceInter serviceInter;

    @Autowired
    SecurityServiceImpl securityServiceInter;

    @Autowired
    UserServiceInter userServiceInter;

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

    @RequestMapping(path = "/employees/profile/edit")
    public ModelAndView edit(ModelAndView modelAndView) {
        User loggedInUser = securityServiceInter.getLoggedInUserDetails().getUser();
        loggedInUser = userServiceInter.findById(loggedInUser.getId());
        System.out.println("loggedInUser="+loggedInUser);
        EmployeeProfile emp = loggedInUser.getEmployeeProfile();
        System.out.println("emp="+emp);
        if(emp==null) {
            modelAndView.setViewName("redirect:/");
            modelAndView.setStatus(HttpStatus.BAD_REQUEST);
            return modelAndView;
        }

        modelAndView.addObject("employeeProfile",emp);
        modelAndView.addObject("listLanguages",languageServiceInter.findAll());
        modelAndView.addObject("listSkills",skillDao.findByEnabled(true));
        modelAndView.setViewName("employee/registration");
        return modelAndView;
    }

    @RequestMapping(path = "/employees/register")
    public ModelAndView register(ModelAndView modelAndView, Model model) {
        modelAndView.addObject("employeeProfile",new EmployeeProfile());
    	modelAndView.addObject("listLanguages",languageServiceInter.findAll());
    	modelAndView.addObject("listSkills",skillDao.findByEnabled(true));
        modelAndView.setViewName("employee/registration");
        return modelAndView;
    }

    @RequestMapping(value = "/employees/register",method=RequestMethod.POST)
    public String register(
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
        return "redirect:/";
    }

}
