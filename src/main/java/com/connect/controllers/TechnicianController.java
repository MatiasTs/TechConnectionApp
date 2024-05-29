
package com.connect.controllers;

import com.connect.entities.Technician;
import com.connect.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
@RequestMapping("/professional")
public class TechnicianController {
    
    @Autowired
    private TechnicianService techService;
    
    @GetMapping("/register")
    public String newTechnician(){
        return "register_professional.html";
    }
    
    @PostMapping("/register")
    public String saveTechnician(@ModelAttribute("technician") Technician technician){
        techService.createTechnician(technician);
        return "redirect:/index";
    }
    
}
