package com.example.asset.controller.views.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class UserController {

    @GetMapping(value = "/user-list")
    public ModelAndView listUser() {
        return new ModelAndView("/admin/user/list");
    }

    @GetMapping(value = "/user-edit")
    public ModelAndView editUser(@RequestParam(required = false) Long id) {
        ModelAndView mav = new ModelAndView("/admin/user/edit");
        if (id != null) {
            mav.addObject("id", id);
        }
        return mav;
    }

    @GetMapping(value = "/user-search")
    public ModelAndView editUser(@RequestParam(required = false) String search) {
        ModelAndView mav = new ModelAndView("/admin/user/search");
        if (search != null) {
            mav.addObject("id", search);
        }
        return mav;
    }
}
