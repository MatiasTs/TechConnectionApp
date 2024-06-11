
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
    
    
    public SocialNetwork SocialNetwork(SocialNetwork social) {
       
        return socialRepo.save(social);
        
    }
    
    public SocialNetwork updateSocial(SocialNetwork social) {
       
        return socialRepo.save(social);
        
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
    
    
}
