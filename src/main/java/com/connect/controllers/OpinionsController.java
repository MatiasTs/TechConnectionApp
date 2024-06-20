
package com.connect.controllers;

import com.connect.entities.Opinions;
import com.connect.services.OpinionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/opinions")
public class OpinionsController {
    
    @Autowired
    private OpinionsService opService;
    
    @GetMapping("/new")
    public String newOpinion(Model model){
        model.addAttribute("opinion", new Opinions());
        return "new_opinion.html";
    }
    
    @PostMapping("/new")
    public String saveOpinion(@ModelAttribute("opinions") Opinions opinion){
        opService.createOpinions(opinion);
        return "redirect:/";
    }
    
}
