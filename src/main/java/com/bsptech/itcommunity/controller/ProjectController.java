package com.bsptech.itcommunity.controller;

import com.bsptech.itcommunity.entity.Itproject;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import com.bsptech.itcommunity.service.inter.ItProjectServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    private ItProjectServiceInter itProjectServiceInter;

    @Autowired
    private EmployeeProfileServiceInter employeeProfileServiceInter;

    @RequestMapping(method = RequestMethod.GET, path = "/{projectId}")
    public ModelAndView detail(@PathVariable("projectId") Integer projectId, ModelAndView modelAndView) {
        Itproject itproject = itProjectServiceInter.findById(projectId);
       modelAndView.addObject("itproject", itproject);
        modelAndView.setViewName("project/details");
        return modelAndView;
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        List<Itproject> projectList = itProjectServiceInter.findAll();
        modelAndView.addObject("projectList", projectList);
        modelAndView.setViewName("project/index");
        return modelAndView;
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String joinTeam(@RequestParam("projectId") Integer projectId){

        int result= employeeProfileServiceInter.joinProject(projectId);
        if(result==2)
            return "redirect:/projects/"+projectId+"?alreadyjoined";
        else if(result==1)
            return "redirect:/projects/"+projectId+"?joinsuccess";
        else if(result==3)
            return "redirect:/projects/"+projectId+"?alreadysent";
        else
            return "redirect:/projects?error";
    }
}
