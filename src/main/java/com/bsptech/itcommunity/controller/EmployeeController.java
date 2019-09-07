package com.bsptech.itcommunity.controller;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeProfileServiceInter employeeProfileServiceInter;

    @GetMapping(value = {"", "/{page}"})
    public ModelAndView index(
            @PathVariable(name = "page", required = false) Integer page,
            ModelAndView modelAndView,
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "surname", required = false, defaultValue = "") String surname,
            @RequestParam(name = "mail", required = false, defaultValue = "") String mail,
            @RequestParam(name = "number", required = false, defaultValue = "") String number
           
            // ve s.
    ) {
        //DEBUG
        System.out.println("Controller : "+name+" "+surname+" "+mail+" "+number);
        //DEBUG
        
        List<EmployeeProfile>   employeeProfileList = employeeProfileServiceInter.findAll(name,surname,mail,number);
        
        modelAndView.addObject("employeeList", employeeProfileList);
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
