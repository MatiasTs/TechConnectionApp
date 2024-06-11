
package com.connect.services;

import com.connect.entities.Technician;
import com.connect.entities.WorkFinished;
import com.connect.enums.ServicesOffered;
import com.connect.repositories.WorkRepository;
import exception.MiException;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkService {
    
    @Autowired
    private WorkRepository workRepo;
    
    
    public WorkFinished createWork(WorkFinished work) {
        
        return workRepo.save(work);
    }
    
    public WorkFinished updateWork(WorkFinished work) {
        
        return workRepo.save(work);
    }
    
    public void deleteWork(String id){
        workRepo.deleteById(id);
    }
    
    public WorkFinished searchWorkDoneById(String id){
        
        Optional<WorkFinished> response = workRepo.findById(id);
        if(response.isPresent()){
            return response.get();
        }
        
        return null;
    }
    
    
}
