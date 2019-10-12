package com.bsptech.itcommunity.controller;

import com.bsptech.itcommunity.dao.SkillDataInter;
import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.Language;
import com.bsptech.itcommunity.entity.Skill;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.service.impl.SecurityServiceImpl;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import com.bsptech.itcommunity.service.inter.LanguageServiceInter;
import com.bsptech.itcommunity.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
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

    @RequestMapping(path = "/employees", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView index(
            @ModelAttribute(name = "employeeProfile") EmployeeProfile employeeProfile,
            ModelAndView modelAndView
    ) {
        Integer currentPage=employeeProfile.getPage()!=null? employeeProfile.getPage():0;
        Page<EmployeeProfile> list = employeeProfileServiceInter.search(employeeProfile,new PageRequest(currentPage,10));
        List<Language> languages = languageServiceInter.findAll();
        List<Skill> skills = skillDao.findAll();
        modelAndView.addObject("languages", languages);
        modelAndView.addObject("skills", skills);
        modelAndView.addObject("employeeList", list);
        modelAndView.addObject("currentPage",currentPage);
        modelAndView.addObject("empService",employeeProfileServiceInter);
        modelAndView.setViewName("employee/index");

        return modelAndView;
    }

    @RequestMapping(path = "/employees/{employeeId}")
    public ModelAndView detail(@PathVariable("employeeId") Integer employeeId, ModelAndView modelAndView) {
        modelAndView.setViewName("employee/details");
        EmployeeProfile emp = employeeProfileServiceInter.findById(employeeId);
        modelAndView.addObject("p",emp);
        return modelAndView;
    }

    @RequestMapping(path = "/employees/profile/edit")
    public ModelAndView editPage(ModelAndView modelAndView) {


        User loggedInUser = securityServiceInter.getLoggedInUserDetails().getUser();
        loggedInUser = userServiceInter.findById(loggedInUser.getId());
        EmployeeProfile emp = loggedInUser.getEmployeeProfile();
        if(emp==null) {
            modelAndView.setViewName("redirect:/");
            modelAndView.setStatus(HttpStatus.BAD_REQUEST);
            return modelAndView;
        }

        modelAndView.addObject("employeeProfile",emp);
        modelAndView.addObject("listLanguages",languageServiceInter.findAll());
        modelAndView.addObject("listSkills",skillDao.findAll());
        modelAndView.setViewName("employee/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/employees/profile/edit",method=RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute @Valid EmployeeProfile employeeProfile,
                             BindingResult result) {
        if(result.hasErrors()) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("employee/edit");
            return mv;
        }
        EmployeeProfile ep = employeeProfileServiceInter.update(employeeProfile);
        return new ModelAndView("redirect:/employees/profile/edit?succes=true");
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
    public ModelAndView register(
                @ModelAttribute @Valid
                EmployeeProfile employeeProfile,
                BindingResult result) {
        System.out.println("I am here");
        if(result.hasErrors()) {
            System.out.println("has errors");
            System.out.println(result.getAllErrors());
            System.out.println("fields="+ Arrays.asList(result.getSuppressedFields()));
            ModelAndView mv = new ModelAndView();
            mv.addObject("listLanguages",languageServiceInter.findAll());
            mv.addObject("listSkills",skillDao.findByEnabled(true));
            mv.setViewName("employee/registration");
            return mv;
        }
    	EmployeeProfile ep = employeeProfileServiceInter.register(employeeProfile);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(path = "/about")
    public String about() {
        return "about";
    }

}
