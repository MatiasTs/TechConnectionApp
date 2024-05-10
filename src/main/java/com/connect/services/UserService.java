
package com.connect.services;

import com.connect.entities.Contact;
import com.connect.entities.Image;
import com.connect.enums.Roles;
import exception.MiException;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    
    
    
    
    
    public boolean validacion(String name, String password, String confirmPassword, String lastName, Contact contact,
            Roles rol, Date dateOfBird, Image image) throws MiException{
        if(name.isEmpty()){
            throw new MiException("The name cannot be empty");
        }
        
        return true;
    }
}
