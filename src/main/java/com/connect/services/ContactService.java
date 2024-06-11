
package com.connect.services;

import com.connect.entities.Contact;
import com.connect.entities.SocialNetwork;
import com.connect.repositories.ContactRepository;
import exception.MiException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository contaRepo;
    
    @Transactional
    public Contact createContact(Contact contact){
        
        return contaRepo.save(contact);
        
    }
    
    @Transactional
    public Contact updateContact(Contact contact){
        
        return contaRepo.save(contact);
        
    }
    
    
    @Transactional
    public void deleteContact(String id){
        contaRepo.deleteById(id);
    }
    
    public Contact searchContactById(String id){
        Optional<Contact> response = contaRepo.findById(id);
        if(response.isPresent()){
            return response.get();
        }
        
        return null;
    }
    
    
}
