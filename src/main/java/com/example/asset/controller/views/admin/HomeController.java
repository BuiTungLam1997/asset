package com.example.asset.controller.views.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController(value = "homeControllerOfAdmin")
@RequestMapping(value = "/admin")
public class HomeController {

    @GetMapping(value = "/home")
    public ModelAndView homeAdmin() {
        return new ModelAndView("admin/home");
    }
}
