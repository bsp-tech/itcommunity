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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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

    @RequestMapping(path = "/employees", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView index(
            @ModelAttribute(name = "employeeProfile") EmployeeProfile employeeProfile,
            ModelAndView modelAndView
    ) {
        List<EmployeeProfile> list = employeeProfileServiceInter.search(employeeProfile);
        List<Language> languages = languageServiceInter.findAll();
        List<Skill> skills = skillDao.findAll();

        modelAndView.addObject("languages", languages);
        modelAndView.addObject("skills", skills);
        modelAndView.addObject("employeeList", list);

        modelAndView.setViewName("employee/index");

        return modelAndView;
    }

    @RequestMapping(path = "/employees/{employeeId}")
    public ModelAndView detail(@PathVariable("employeeId") Integer employeeId, ModelAndView modelAndView) {
        modelAndView.setViewName("employee/details");
        if(employeeId==1)
            throw new RuntimeException();
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
        modelAndView.addObject("listSkills",skillDao.findByEnabled(true));
        modelAndView.setViewName("employee/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/employees/profile/edit",method=RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute @Valid EmployeeProfile employeeProfile,
                             BindingResult result) {
        System.out.println("languagelist="+employeeProfile.getEmployeeProfileLanguageList());

//        if(result.hasErrors()) {
//            ModelAndView mv = new ModelAndView();
//            mv.setViewName("employee/registration");
//            return mv;
//        }
//        EmployeeProfile ep = employeeProfileServiceInter.register(employeeProfile);
        return new ModelAndView("redirect:/employees/profile/edit");
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

        if(result.hasErrors()) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("employee/registration");
            return mv;
        }
    	EmployeeProfile ep = employeeProfileServiceInter.register(employeeProfile);
        return new ModelAndView("redirect:/");
    }


}
