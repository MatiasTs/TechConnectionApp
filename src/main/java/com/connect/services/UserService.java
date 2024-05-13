
package com.connect.services;

import com.connect.entities.Contact;
import com.connect.entities.Image;
import com.connect.enums.Roles;
import exception.MiException;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
//    public void addUser(String name, String password, String confirmPassword, String lastName,String userName,
//            Contact contact, String NIC, Date dateOfBird, Image image) throws MiException{
//        
//        validation(name, password, confirmPassword, lastName, userName, contact, NIC, dateOfBird, image);
//        
//        
//        
//    }
    
    
    
    
    public void validation(String name, String password, String confirmPassword, String lastName,String userName,
            Contact contact, String NIC, Date dateOfBird, Image image) throws MiException{
        if(name.isEmpty() || name == null){
            throw new MiException("The name cannot be empty or null");
        }
        
        if(lastName.isEmpty() || lastName == null){
            throw new MiException("The lastName cannot be empty or null");
        }
        
        if(userName.isEmpty() || userName == null){
            throw new MiException("The userName cannot be empty or null");
        }
        
        if(password.isEmpty() || password == null || confirmPassword.isEmpty() || confirmPassword == null){
            throw new MiException("The password cannot be empty or null");
        }
        
        if(password.length() < 8){
            throw new MiException("The password cannot have fewer than 8 characters");
        }
        
        if(!password.equals(confirmPassword)){
            throw new MiException("The passwords don't match");
        }
        
        if(contact == null){
            throw new MiException("The contact cannot be null");
        }
        
        if(NIC.isEmpty() || NIC == null){
            throw new MiException("The National Identity Card cannot be empty");
        }
        
        
    }
}
