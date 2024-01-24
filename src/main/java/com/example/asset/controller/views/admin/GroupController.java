package com.example.asset.controller.views.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class GroupController {

    @GetMapping(value = "/group-list")
    public ModelAndView listUser() {
        return new ModelAndView("/admin/group/list");
    }

    @GetMapping(value = "/group-edit")
    public ModelAndView editUser(@RequestParam(required = false) Long id) {
        ModelAndView mav = new ModelAndView("/admin/group/edit");
        if (id != null) {
            mav.addObject("id", id);
        }
        return mav;
    }

    @GetMapping(value = "/group-search")
    public ModelAndView editUser(@RequestParam(required = false) String search) {
        ModelAndView mav = new ModelAndView("/admin/group/search");
        if (search != null && !search.isEmpty()) {
            mav.addObject("searchResponse", search);
            return mav;
        }
        return new ModelAndView("/admin/group/list");
    }
}
