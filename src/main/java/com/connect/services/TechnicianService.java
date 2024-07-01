
package com.connect.services;

import com.connect.entities.Address;
import com.connect.entities.Contact;
import com.connect.entities.Technician;
import com.connect.entities.WorkFinished;
import com.connect.enums.ServicesOffered;
import com.connect.repositories.TechnicianRepository;
import exception.MiException;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.ArrayUtils;

@Service
public class TechnicianService {
    
    @Autowired
    private TechnicianRepository TechnicianRepository;
    
    @Autowired
    private UserService userService;
    
    
    @Transactional
    public Technician createTechnician(Technician technician){
        
   
        return TechnicianRepository.save(technician);
        
    }
    
    @Transactional
    public Technician modifyTechnician(Technician technician){
        
        return TechnicianRepository.save(technician);
    }
    
    @Transactional
    public void technicianDelete(String id){
        TechnicianRepository.deleteById(id);
    }
    
    public Technician searchById(String id){
        Optional<Technician> response = TechnicianRepository.findById(id);
        if(response.isPresent()){
            return response.get();
        }
        return null;
    }
    
    public List<Technician> allTechnicianOrderByUserName(){
        return TechnicianRepository.findAllByOrderByUserNameAsc();
    }
    
    
   
}
