
package com.connect.services;

import com.connect.entities.Opinions;
import com.connect.entities.Technician;
import com.connect.repositories.OpinionsRepository;
import exception.MiException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpinionsService {
    
    @Autowired
    private OpinionsRepository opRepo;
    
    public Opinions createOpinions(Opinions opinions){
        
        return opRepo.save(opinions);
  
    }
    
    
    public Opinions updateOpinions(Opinions opinions){
        
        return opRepo.save(opinions);
  
    }
    
    public void deleteOpinions(String id){
        opRepo.deleteById(id);
    }
    
    public Opinions searchById(String id){
        Optional<Opinions> response = opRepo.findById(id);
        if(response.isPresent()){
            return response.get();
        }
        return null;
    }
    

}
