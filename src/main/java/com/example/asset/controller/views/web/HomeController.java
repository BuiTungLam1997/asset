package com.example.asset.controller.views.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController(value = "homeControllerOfWeb")
@RequestMapping()
public class HomeController {


    @GetMapping(value = "/web/home")
    public ModelAndView homePage() {
        return new ModelAndView("web/home");
    }

    @GetMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

}
