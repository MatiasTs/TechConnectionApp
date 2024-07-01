
package com.connect.services;

import com.connect.entities.Address;
import com.connect.entities.Contact;

import com.connect.entities.Resident;
import com.connect.repositories.ResidentRepository;
import com.connect.repositories.UserRepository;
import exception.MiException;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResidentService {
    
    @Autowired
    private UserService userService;
   
    @Autowired
    private ResidentRepository residentRepository;
    
    @Autowired
    private UserRepository userRepository;
    
   
    @Transactional
    public Resident createResident(Resident resident) {
        
        return residentRepository.save(resident);
    }
    
    @Transactional
    public Resident uptdate(Resident resident) {
        
        return residentRepository.save(resident);
    }
    
    
    @Transactional
    public void deleteResident(String id){
        residentRepository.deleteById(id);
    }
    
    public Resident searchById(String id){
        Optional<Resident> response = residentRepository.findById(id);
        if(response.isPresent()){
            Resident resident = response.get();
            return resident;
        }
        return null;
    }
    
    public List<Resident> listResidents(){
        return residentRepository.findAllByOrderByUserNameAsc();
    }
    
   
}
