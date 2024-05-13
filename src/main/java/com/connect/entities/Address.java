
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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String street;
    private String residentNumber;
    private String housingType;
    private Integer floor;
    private String doorNumber;
    private String postalCode;
    private String city;
    
    @OneToOne
    private Resident resident;
}
