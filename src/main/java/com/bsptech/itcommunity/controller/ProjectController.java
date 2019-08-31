package com.bsptech.itcommunity.controller;

import com.bsptech.itcommunity.entity.Itproject;
import com.bsptech.itcommunity.service.impl.EmployeeProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import com.bsptech.itcommunity.service.inter.ItProjectServiceInter;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {
    @Autowired
    private EmployeeProjectServiceImpl employeeItProjectServiceInter;
    @Autowired
    private ItProjectServiceInter itProjectServiceInter;


    @RequestMapping(method = RequestMethod.GET, path = "/{projectId}")
    public ModelAndView detail(@PathVariable("projectId") Integer projectId, ModelAndView modelAndView) {
        Itproject itproject = itProjectServiceInter.findById(projectId);
//        modelAndView.addObject("project", itproject);
//        modelAndView.addObject("developers", employeeItProjectServiceInter.findAllByItProjectId(itproject));
        modelAndView.setViewName("/project/details");
        return modelAndView;
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        List<Itproject> projectList = itProjectServiceInter.findAll();
        modelAndView.addObject("projectList", projectList);
        modelAndView.setViewName("project/index");
        return modelAndView;
    }
}
