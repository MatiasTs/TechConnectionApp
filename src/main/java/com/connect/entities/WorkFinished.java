
package com.connect.entities;

import com.connect.enums.ServicesOffered;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class WorkFinished {
    
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @OneToOne
    private ServicesOffered jobDone;
    
    private Double hours;
    private Double price;
    
    @ManyToOne
    private Professional professional;
}
