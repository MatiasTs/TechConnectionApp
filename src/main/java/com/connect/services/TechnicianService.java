
package com.connect.services;

import com.connect.entities.Address;
import com.connect.entities.Contact;
import com.connect.entities.Image;
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
import org.thymeleaf.util.ArrayUtils;

@Service
public class TechnicianService {
    
    @Autowired
    private TechnicianRepository TechnicianRepository;
    
    @Autowired
    private UserService userService;
    
    @Transactional
    public void createTechnician(String name, String password, String confirmPassword, String lastName,String userName,
            Contact contact, String NIC, Date dateOfBird, Image image, Address address,
            ServicesOffered service, List<WorkFinished> works, Double hourlyRate) throws MiException{
        
        userService.validation(name, password, confirmPassword, lastName, userName, contact, NIC, dateOfBird, image);
        
        techValidation(service, hourlyRate);
        
        Technician technician = new Technician();
        
        technician.setName(name);
        technician.setPassword(password);
        technician.setLastName(lastName);
        technician.setUserName(userName);
        technician.setContacto(contact);
        technician.setNIC(NIC);
        technician.setDateOfBirth(dateOfBird);
        technician.setImage(image);
        
        technician.setService(service);
        technician.setHourlyRate(hourlyRate);
        
        if(!works.isEmpty()){
            technician.setWorkFinished(works);
        }
        
        TechnicianRepository.save(technician);
        
    }
    
    @Transactional
    public void modifyTechnician(String id, String name, String password, String confirmPassword, String lastName,String userName,
            Contact contact, String NIC, Date dateOfBird, Image image, Address address,
            ServicesOffered service, List<WorkFinished> works, Double hourlyRate) throws MiException{
        
        userService.validation(name, password, confirmPassword, lastName, userName, contact, NIC, dateOfBird, image);
        
        techValidation(service, hourlyRate);
        
        Optional<Technician> response = TechnicianRepository.findById(id);
        
        if(response.isPresent()){
            Technician technician = response.get();
            
            technician.setName(name);
            technician.setPassword(password);
            technician.setLastName(lastName);
            technician.setUserName(userName);
            technician.setContacto(contact);
            technician.setNIC(NIC);
            technician.setDateOfBirth(dateOfBird);
            technician.setImage(image);

            technician.setService(service);
            technician.setHourlyRate(hourlyRate);

            if(!works.isEmpty()){
                technician.setWorkFinished(works);
            }

            TechnicianRepository.save(technician);
            
            }
 
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
        return TechnicianRepository.techniciansOrderByUserName();
    }
    
    
    public void techValidation(ServicesOffered service, Double hourlyRate) throws MiException{
        if(service == null){
            throw new MiException("The service oferred cannot be empty");
        }
        
        if(hourlyRate == null){
            throw new MiException("The hourly rate cannot be empty");
        }
    }
}
