package com.example.asset.controller.views.admin;

import com.example.asset.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class DeviceController {

   @GetMapping(value = "/device-list")
    public ModelAndView listDevice(){
       return new ModelAndView("/admin/device/list");
   }

    @GetMapping(value = "/device-edit/{id}")
    public ModelAndView listDevice(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("/admin/device/edit");
        if (id != null) {
            mav.addObject("id", id);
        }
        return mav;
    }

}
