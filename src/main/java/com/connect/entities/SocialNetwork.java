
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
public class SocialNetwork {
    
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    
    @NotBlank(message= "The name cannot be empty")
    private String name;
    
    @NotBlank(message= "The username cannot be empty")
    private String myUserName;
    
    @ManyToOne
    private Contact Contact;
}
