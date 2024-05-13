
package com.connect.repositories;

import com.connect.entities.Resident;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, String>{
    
    @Query("SELECT r FROM Resident r ORDER BY r.userName ASC")
    List<Resident> residentsOrderByUsername();
    
}
