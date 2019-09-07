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
            @RequestParam(name = "number", required = false, defaultValue = "") String number,
            @RequestParam(name = "eng" , required = false , defaultValue = "0") int engLev,
            @RequestParam(name = "turk" , required = false , defaultValue = "0") int turkLev,
            @RequestParam(name = "germ" , required = false , defaultValue = "0") int germLev,
            @RequestParam(name = "ital" , required = false , defaultValue = "0") int italLev,
            @RequestParam(name = "pyth" , required = false , defaultValue = "0") int pythLev,
            @RequestParam(name = "php" , required = false , defaultValue = "0") int phpLev,
            @RequestParam(name = "java" , required = false , defaultValue = "0") int javaLev,
            @RequestParam(name = "c" , required = false , defaultValue = "0") int cLev
            // ve s.
    ) {
        //DEBUG
        System.out.println("Controller : "+name+" "+surname+" "+mail+" "+number);
        System.out.println(engLev+" "+turkLev+" "+germLev+" "+italLev);
        System.out.println(pythLev+" "+phpLev+" "+javaLev+" "+cLev);
        //DEBUG
        
        // BEGIN PAGINATION
        if(page==null) page=1;
        
        PageRequest pageable = PageRequest.of(page - 1,10);
        Page<EmployeeProfile> listPage = employeeProfileServiceInter.getPaginatedEmployees(pageable);

        int totalPages = listPage.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        // END PAGINATION
        
        List<EmployeeProfile> employeeProfileList = employeeProfileServiceInter.findAllWithPagianation(page,name,surname,mail,number);
        
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
