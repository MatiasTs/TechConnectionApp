
package com.connect.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Resident extends User{
    
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    
    @NotNull
    @OneToOne
    private Address address;
}
