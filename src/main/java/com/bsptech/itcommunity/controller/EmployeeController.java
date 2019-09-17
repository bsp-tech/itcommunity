package com.bsptech.itcommunity.controller;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.Language;
import com.bsptech.itcommunity.entity.Skill;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import com.bsptech.itcommunity.service.inter.LanguageServiceInter;
import com.bsptech.itcommunity.service.inter.SkillServiceInter;
import com.bsptech.itcommunity.dao.SkillDataInter;
import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.EmployeeProject;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.service.impl.SecurityServiceImpl;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import com.bsptech.itcommunity.service.inter.LanguageServiceInter;
import com.bsptech.itcommunity.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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

    @RequestMapping(path = "/employees/profile/edit")
    public ModelAndView edit(ModelAndView modelAndView) {
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
                @ModelAttribute @Valid EmployeeProfile employeeProfile,
                BindingResult result) {
        if(result.hasErrors()) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("employee/registration");
            return mv;
        }
    	EmployeeProfile ep = employeeProfileServiceInter.register(employeeProfile);
        return new ModelAndView("redirect:/");
    }

      @RequestMapping("/")
      public String join_team(
               @ModelAttribute("employeeProject") EmployeeProject employeeProject){
        if(employeeProject.getEmployeeId()==null){
            return "redirect:/project/index?success";
        }else
            return "redirect:/project/index?error";

      }
}
