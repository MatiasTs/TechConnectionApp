
package com.connect.repositories;

import com.connect.entities.WorkFinished;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<WorkFinished, String>{
    
}
