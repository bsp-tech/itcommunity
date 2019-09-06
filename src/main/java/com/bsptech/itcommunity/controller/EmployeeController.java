package com.bsptech.itcommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.collections4.IteratorUtils;

import com.bsptech.itcommunity.dao.EmployeeProfileDataInter;
import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.EmployeeProfileLanguage;
import com.bsptech.itcommunity.entity.EmployeeProfileSkill;
import com.bsptech.itcommunity.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class EmployeeController {

    private Integer pages;

    @Autowired
    EmployeeProfileDataInter employeeProfileDataInter;

    @GetMapping(value = {"", "/{page}"})
    public ModelAndView index(
            @PathVariable(name = "page", required = false) String pageS,
            ModelAndView modelAndView,
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "surname", required = false, defaultValue = "") String surname,
            @RequestParam(name = "mail", required = false, defaultValue = "") String mail,
            @RequestParam(name = "number", required = false, defaultValue = "") String number
        ){

        Iterable<EmployeeProfile> it = employeeProfileDataInter.findAll();

        List<EmployeeProfile> employeeProfileList = IteratorUtils.toList(it.iterator());//butun list
        List<EmployeeProfile> listPagination = new ArrayList<>();//pagination list

        Integer size = employeeProfileList.size();

        //Total sehife sayini teyin edir.
        if (size % 10 == 0) {//==0 - pages ,, !=0 + pages+1
            pages = size / 10;
        } else {
            pages = size / 10 + 1;
        }

        Integer page = null;
        Integer firstIndex = null;
        Integer lastIndex = null;
        
        //PAGINATION - page-1,page,page+1

        if (pageS != null) { //page e click olunub,
            page = Integer.valueOf(pageS);
            firstIndex = page * 10 - 10; 
            lastIndex = page * 10 - 1;
        } else if (page == pages) { //limit i teyin edir.
            firstIndex = page * 10 - 10;
            lastIndex = page * 10 - 1;
            page--;
        } else if (page == null) { //Sehife ilk defe yuklenib
            System.out.println("xello");
            page = 1;
            firstIndex = 0;
            lastIndex = 9;
        }

        modelAndView.addObject("pages", pages);
        modelAndView.addObject("page", page);

        //eger son index, size dan boyukdurse, onda son index list uzunlugu olur
        if (lastIndex > size) {
            lastIndex = size - 1;
//            modelAndView.addObject("page", page-1);
        }

        if (name.equals("") && surname.equals("") && mail.equals("") && number.equals("")) { // default

            for (int i = firstIndex; i <= lastIndex; i++) {
                listPagination.add(employeeProfileList.get(i));
            }

            modelAndView.addObject("employeeList", listPagination);
            modelAndView.addObject("pagination", true);

        } else { // search

            List<EmployeeProfile> listFilter = new ArrayList<>();

            for (EmployeeProfile employeeFilter : employeeProfileList) {
                User user = employeeFilter.getUserId();
                

                if (user.getName().toLowerCase().equals(name.toLowerCase())
                        || user.getSurname().toLowerCase().equals(surname.toLowerCase())
                        || user.getEmail().toLowerCase().equals(mail.toLowerCase())
                        || user.getNumber().toLowerCase().equals(number.toLowerCase())) {

                    listFilter.add(employeeFilter);

                }
            }
           

            modelAndView.addObject("employeeList", listFilter);
            modelAndView.addObject("pagination", false);

        }

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
