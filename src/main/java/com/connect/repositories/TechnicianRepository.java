package com.connect.repositories;

import com.connect.entities.Technician;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, String>{
    
    List<Technician> findAllByOrderByUserNameAsc();
    
}
