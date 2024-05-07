
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
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Professional {
    
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "service")
    private ServicesOffered service;
    
    @OneToMany
    private List<WorkFinished> workFinished;
    
    @OneToMany
    private List<Opinions> opinions;
    
    private Double hourlyRate;
    
    
}
