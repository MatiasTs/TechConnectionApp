
package com.connect.entities;

import com.connect.enums.ServicesOffered;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Technician extends User{
    
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "service")
    private ServicesOffered service;
    
    @NotNull
    @OneToMany
    private List<WorkFinished> workFinished;
    
    @NotNull
    @OneToMany
    private List<Opinions> opinions;
    
    private Double hourlyRate;
    
    
}
