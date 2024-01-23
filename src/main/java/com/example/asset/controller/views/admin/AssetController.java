package com.example.asset.controller.views.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AssetController {

    @GetMapping(value = "/asset-list")
    public ModelAndView listDevice() {
        return new ModelAndView("/admin/asset/list");
    }

    @GetMapping(value = "/asset-edit")
    public ModelAndView listDevice(@RequestParam(required = false) Long id) {
        ModelAndView mav = new ModelAndView("/admin/asset/edit");
        if (id != null) {
            mav.addObject("id", id);
            return mav;
        }
        return new ModelAndView("/admin/asset/edit");
    }

    @GetMapping(value = "/asset-search")
    public ModelAndView listDevice(@RequestParam(required = false) String search) {
        ModelAndView mav = new ModelAndView("/admin/asset/search");
        if (search != null) {
            mav.addObject("searchResponse", search);
            return mav;
        }
        return new ModelAndView("/admin/asset/list");
    }

}
