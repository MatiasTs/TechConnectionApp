
package com.connect.controllers;

import com.connect.entities.Resident;
import com.connect.services.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resident")
public class ResidentController {
    
    @Autowired
    private ResidentService resService;
    
    @GetMapping("/register")
    public String registerResident(Model model){
        model.addAttribute("resident", new Resident());
        return "register_resident.html";
    }
    
    @PostMapping("/register")
    public String saveResident(@ModelAttribute("resident") Resident resident){
        resService.createResident(resident);
        return "redirect:/";
    }
}
