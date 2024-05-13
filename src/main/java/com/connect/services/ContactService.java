
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
    public void createContact(String phoneNumber, String cellphone, String email,
            List<SocialNetwork> socialNetwork) throws MiException{
        
        Contact contact = new Contact();
        
        if(!phoneNumber.isEmpty() && phoneNumber != null){
            contact.setPhoneNumber(phoneNumber);
        }
        
        if(!cellphone.isEmpty() && cellphone != null){
            contact.setCellphone(cellphone);
        }
        
        if(!email.isEmpty() && email != null){
            contact.setEmail(email);
        }
        
        if(socialNetwork != null && socialNetwork.size() > 0){
            contact.setSocialNetworks(socialNetwork);
        }
        
        contaRepo.save(contact);
        
    }
    
    @Transactional
    public void modifyContact(String id, String phoneNumber, String cellphone, String email,
            List<SocialNetwork> socialNetwork) throws MiException{
        
        
        Optional<Contact> response = contaRepo.findById(id);
        if(response.isPresent()){
            Contact contact = response.get();
            contact.setPhoneNumber(phoneNumber);
            contact.setCellphone(cellphone);
            contact.setEmail(email);
            contact.setSocialNetworks(socialNetwork);
        
            contaRepo.save(contact);
        }
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
