
package com.connect.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Resident extends User{
    
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    
    @OneToOne
    private Address address;
}
