
package com.connect.services;

import com.connect.entities.Contact;
import com.connect.entities.SocialNetwork;
import com.connect.repositories.SocialRepository;
import exception.MiException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialService {
    
    @Autowired
    private SocialRepository socialRepo;
    
    
    public void createSocial(String name, String myUserName, Contact contact) throws MiException{
        validation(name, myUserName, contact);
        
        SocialNetwork social = new SocialNetwork();
        social.setContact(contact);
        social.setMyUserName(myUserName);
        social.setName(name);
        socialRepo.save(social);
    }
    
    public void modifySocial(String id, String name, String myUserName, Contact contact) throws MiException{
        validation(name, myUserName, contact);
        
        Optional<SocialNetwork> response = socialRepo.findById(id);
        if(response.isPresent()){
            SocialNetwork social = response.get();
            social.setContact(contact);
            social.setMyUserName(myUserName);
            social.setName(name);
            socialRepo.save(social);
        }
    }
    
    public void deleteSocial(String id){
        socialRepo.deleteById(id);
    }
    
    public SocialNetwork searchSocialById(String id){
         Optional<SocialNetwork> response = socialRepo.findById(id);
        if(response.isPresent()){
            return response.get();
        }
        
        
        return null;
    }
    
    public void validation(String name, String myUserName, Contact contact) throws MiException{
        if(name.isEmpty() || name == null){
            throw new MiException("The name of the social network cannot be empty");
        }
        
        if(myUserName.isEmpty() || myUserName == null){
            throw new MiException("The user name cannot be empty");
        }
        
        if(contact == null){
            throw new MiException("The contact cannot be empty");
        }
    }
}
