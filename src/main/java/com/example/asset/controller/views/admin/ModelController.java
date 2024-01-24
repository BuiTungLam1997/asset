package com.example.asset.controller.views.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class ModelController {

    @GetMapping(value = "/model-list")
    public ModelAndView listUser() {
        return new ModelAndView("/admin/model/list");
    }

    @GetMapping(value = "/model-edit")
    public ModelAndView editUser(@RequestParam(required = false) Long id) {
        ModelAndView mav = new ModelAndView("/admin/model/edit");
        if (id != null) {
            mav.addObject("id", id);
        }
        return mav;
    }

    @GetMapping(value = "/model-search")
    public ModelAndView editUser(@RequestParam(required = false) String search) {
        ModelAndView mav = new ModelAndView("/admin/model/search");
        if (search != null && !search.isEmpty()) {
            mav.addObject("searchResponse", search);
            return mav;
        }
        return new ModelAndView("/admin/model/list");
    }
}
