
package com.connect.entities;

import com.connect.enums.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rol",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("USER")
@Entity

public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private String NIC;
    
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
   
   @OneToOne
   private Image image;
   
   @OneToOne
   private Contact contacto;
   
   @Enumerated(EnumType.STRING)
   @Column(name = "rol")
   private Roles rol;
   
}
