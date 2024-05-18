
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
    
    
    public void createWork(Date date, ServicesOffered jobDone, Double hours, Double price,
            Technician technician) throws MiException{
        
        
        WorkFinished work = new WorkFinished();
        
        work.setDate(date);
        work.setHours(hours);
        work.setPrice(price);
        work.setTechnician(technician);
        work.setJobDone(jobDone);
        workRepo.save(work);
        
    }
    
    
    public void modifyWork(String id, Date date, ServicesOffered jobDone, Double hours, Double price,
            Technician technician) throws MiException{
        
        
        Optional<WorkFinished> response = workRepo.findById(id);
        if(response.isPresent()){
            WorkFinished work = response.get();
            work.setDate(date);
            work.setHours(hours);
            work.setPrice(price);
            work.setTechnician(technician);
            work.setJobDone(jobDone);
            workRepo.save(work);
            
        }
        
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
