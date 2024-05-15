
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
    
    public void createOpinions(String comments, Double score, Technician technician)throws MiException{
        
        validation(comments, score, technician);
        
        Opinions opinions = new Opinions();
        opinions.setComments(comments);
        opinions.setScore(score);
        opinions.setTechnician(technician);
        
        opRepo.save(opinions);
  
    }
    
    
    public void modifyOpinions(String id, String comments, Double score, Technician technician)throws MiException{
        validation(comments, score, technician);
        
        Optional<Opinions> response = opRepo.findById(id);
        if(response.isPresent()){
            Opinions opinions = new Opinions();
            opinions.setComments(comments);
            opinions.setScore(score);
            opinions.setTechnician(technician);

            opRepo.save(opinions);
        }
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
    
    public void validation(String comments, Double score, Technician technician) throws MiException{
        if(comments.isEmpty() || comments == null){
            throw new MiException("The comments cannot be empty");
        }
        
        if(score == null){
            throw new MiException("The score cannot be empty");
        }
        
        if(technician == null){
            throw new MiException("The technician cannot be empty");
        }
    }
    
}
