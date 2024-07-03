
package com.connect.controllers;

import com.connect.entities.Technician;
import com.connect.enums.ServicesOffered;
import com.connect.services.ResidentService;
import com.connect.services.StorageService;
import com.connect.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private TechnicianService techService;
    
    @Autowired
    private ResidentService resService;
    
    @Autowired
    private StorageService storageService;
    
    @GetMapping("/professional/{id}/edit")
    public ModelAndView editProfesional(@PathVariable String id){
        Technician technician = techService.searchById(id);
        ServicesOffered[] services = ServicesOffered.values();
        
        return new ModelAndView("edit_professional.html")
                    .addObject("technician", technician)
                    .addObject("services",services);
    }
    
    @PostMapping("/professional/{id}/edit")
    public ModelAndView updateProfessional(@PathVariable String id, @Validated Technician technician, BindingResult bindingResult){
        
        if (bindingResult.hasErrors()){
            ServicesOffered[] services = ServicesOffered.values();
            return new ModelAndView("edit_professional.html")
                    .addObject("technician", technician)
                    .addObject("services",services);
        }
        
        Technician technicianUP = techService.searchById(id);
        
        technicianUP.setName(technician.getName());
        technicianUP.setLastname(technician.getLastname());
        technicianUP.setAddress(technician.getAddress());
        technicianUP.setDateOfBirth(technician.getDateOfBirth());
        technicianUP.setHourlyRate(technician.getHourlyRate());
        technicianUP.setNIC(technician.getNIC());
        technicianUP.setPhone(technician.getPhone());
        technicianUP.setService(technician.getService());
        technicianUP.setUserName(technician.getUserName());
        
        if(!technician.getImage().isEmpty()){
            storageService.deleteFile(technicianUP.getImageRoute());
            String routeFile = storageService.storageFile(technician.getImage());
            technicianUP.setImageRoute(routeFile);
        }
        
        return new ModelAndView("redirect:/"); 
    }
    
    @PostMapping("/professional/{id}/delete")
    public String deleteTechnician(@PathVariable String id){
        techService.technicianDelete(id);
        return "redirect:/";
    }
    
}
