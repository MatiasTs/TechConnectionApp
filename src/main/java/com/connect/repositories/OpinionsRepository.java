
package com.connect.repositories;

import com.connect.entities.Opinions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionsRepository extends JpaRepository<Opinions, String>{
    
}
