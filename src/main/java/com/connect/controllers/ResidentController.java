
package com.connect.controllers;

import com.connect.entities.Resident;
import com.connect.enums.Roles;
import com.connect.services.ResidentService;
import com.connect.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/resident")
public class ResidentController {
    
    @Autowired
    private ResidentService resService;
    
    @Autowired
    private StorageService storageService;
    
    @GetMapping("/register")
    public ModelAndView newResident(){
        
        
        return new ModelAndView("register_resident.html")
                    .addObject("resident", new Resident());
        
    }
    
    @PostMapping("/register")
    public ModelAndView saveResident(@Validated Resident resident, BindingResult bindingResult){
        
        if(bindingResult.hasErrors()){
            return new ModelAndView("register_resident.html")
                    .addObject("resident", resident);
        }
        
        if (!resident.getImage().isEmpty()){
            
            String imageRoute = storageService.storageFile(resident.getImage());
            resident.setImageRoute(imageRoute);
        }else{
            resident.setImageRoute(null);
        }
        
        resident.setRol(Roles.RESIDENT);
        resService.createResident(resident);
        return new ModelAndView("redirect:/");
    }
}
