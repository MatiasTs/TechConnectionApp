
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
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String streetName;
    private Integer number;
    private String blockLetter;
    private Integer floor;
    private String apartNumber;
    private Integer postalNumber;
    private String city;
    
    @OneToOne
    private Resident resident;
}
