
package com.connect.entities;

import com.connect.enums.ServicesOffered;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "TECHNICIAN")
@DiscriminatorValue("TECHNICIAN")
@Entity
public class Technician extends User{
    
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "service")
    private ServicesOffered service;
    
    @NotBlank(message = "The address cannot be null")
    private String address;
    
    
    @OneToMany
    private List<WorkFinished> workFinished;
    
    
    @OneToMany
    private List<Opinions> opinions;
    
    private Double hourlyRate;
    
    
}
