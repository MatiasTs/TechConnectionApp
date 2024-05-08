
package com.connect.repositories;

import com.connect.entities.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialRepository extends JpaRepository<SocialNetwork, String>{
    
}
