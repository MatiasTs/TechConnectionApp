
package com.connect.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Opinions {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    
    private String comments;
    private Double score;
    
    @ManyToOne
    private Professional professional;
}
