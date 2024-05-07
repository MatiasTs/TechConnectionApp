
package com.connect.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Contact {
    
    @GeneratedValue( strategy = GenerationType.UUID)
    @Id
    private String id;
    
    private String phoneNumber;
    private String cellphone;
    private String email;
    private List<SocialNetwork> socialNetworks;
    
    
}
