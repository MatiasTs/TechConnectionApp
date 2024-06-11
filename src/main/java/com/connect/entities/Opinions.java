
package com.connect.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Opinions {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    
    @NotBlank(message="The comments cannot be empty")
    private String comments;
    
    @NotNull(message = "The score cannot be null")
    private Double score;
    
    @ManyToOne
    private Technician technician;
}
