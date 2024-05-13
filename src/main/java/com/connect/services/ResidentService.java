
package com.connect.services;

import com.connect.entities.Address;
import com.connect.entities.Contact;
import com.connect.entities.Image;
import com.connect.entities.Resident;
import com.connect.repositories.ResidentRepository;
import com.connect.repositories.UserRepository;
import exception.MiException;
import java.util.Date;
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
    
   
    
    public void createResident(String name, String password, String confirmPassword, String lastName,String userName,
            Contact contact, String NIC, Date dateOfBird, Image image, Address address) throws MiException{
        
        userService.validation(name, password, confirmPassword, lastName, userName, contact, NIC, dateOfBird, image);
        
        residentValidation(address);
        
        Resident resident = new Resident();
        
        resident.setName(name);
        resident.setPassword(password);
        resident.setLastName(lastName);
        resident.setUserName(userName);
        resident.setContacto(contact);
        resident.setNIC(NIC);
        resident.setDateOfBirth(dateOfBird);
        resident.setImage(image);
        resident.setAddress(address);
        
        residentRepository.save(resident);
        
    }
    
    
    
    public void residentValidation(Address address) throws MiException{
        
        if(address == null){
            throw new MiException("The address cannot be null");
        }
    }
}
