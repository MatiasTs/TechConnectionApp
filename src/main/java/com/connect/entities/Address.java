
package com.connect.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @NotBlank(message = "The street name cannot be empty")
    private String street;
    @NotBlank(message = "The number of the resident cannot be empty")
    private String residentNumber;
    @NotBlank(message = "The type of the residence cannot be empty")
    private String housingType;
    @NotNull(message = "The floor number cannot be null")
    private Integer floor;
    @NotBlank(message = "The door number cannot be empty")
    private String doorNumber;
    @NotBlank(message = "The postal code cannot be empty")
    private String postalCode;
    @NotBlank(message = "The city cannot be empty")
    private String city;
    
    @NotNull(message = "The resident cannot be empty")
    @OneToOne
    private Resident resident;
}
