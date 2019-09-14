//package com.bsptech.itcommunity.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class AuthController {
//
//    @GetMapping(value = {"/","/login"})
//    public ModelAndView modelAndView(ModelAndView modelAndView) {
//        modelAndView.setViewName("user/login");
//        return modelAndView;
//    }
//
//    @GetMapping("/loginFailed")
//    public ModelAndView loginFailed(ModelAndView modelAndView){
//        modelAndView.addObject("error","Istifadeci adi veya shifre yanlishdir");
//        modelAndView.setViewName("user/login");
//        return modelAndView;
//    }
//
//    @GetMapping("/logout")
//    public ModelAndView logout(ModelAndView modelAndView) {
//        modelAndView.setViewName("user/login");
//        return modelAndView;
//    }
//
//    @GetMapping("/403")
//    public ModelAndView a_403(ModelAndView modelAndView) {
//        modelAndView.addObject("unauth","Sizin bunu etmeye icazeniz yoxdur");
//       // modelAndView.setViewName("");
//        return modelAndView;
//    }
//}
