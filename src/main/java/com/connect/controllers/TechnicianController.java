
package com.connect.controllers;

import com.connect.entities.Technician;
import com.connect.enums.Roles;
import com.connect.enums.ServicesOffered;
import com.connect.services.StorageService;
import com.connect.services.TechnicianService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/professional")
public class TechnicianController {
    
    @Autowired
    private TechnicianService techService;
    
    @Autowired
    private StorageService storageService;
    
    @GetMapping("/register")
    public ModelAndView newTechnician(){
        
        ServicesOffered[] services = ServicesOffered.values();
        
        return new ModelAndView("register_professional.html")
                    .addObject("technician", new Technician())
                    .addObject("services",services);
        
    }
    
    @PostMapping("/register")
    public ModelAndView saveTechnician(@Validated Technician technician, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()){
            ServicesOffered[] services = ServicesOffered.values();
            return new ModelAndView("register_professional.html")
                    .addObject("technician", new Technician())
                    .addObject("services",services);
        }
        
        if (!technician.getImage().isEmpty()){
            
            String imageRoute = storageService.storageFile(technician.getImage());
            technician.setRutaPortada(imageRoute);
        }else{
            technician.setRutaPortada(null);
        }
            

        technician.setRol(Roles.TECHNICIAN);
        
        techService.createTechnician(technician);
        

        return new ModelAndView("redirect:/"); 
    }
}
    
