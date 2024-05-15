
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
        
        validation(date, jobDone, hours, price, technician);
        
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
        
        validation(date, jobDone, hours, price, technician);
        
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
    
    
    
    public void validation(Date date, ServicesOffered jobDone, Double hours, Double price,
            Technician technician) throws MiException{
        
        if(date == null){
            throw new MiException("The date cannot be empty");
        }
        
        if(jobDone == null){
            throw new MiException("The job done cannot be empty");
        }
        
        if(hours == null){
            throw new MiException("The hours cannot be empty");
        }
                
        if(price == null){
            throw new MiException("The price cannot be empty");
        }
        
    }
}
