
package com.connect.entities;

import com.connect.enums.ServicesOffered;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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
    
    @NotNull(message = "The date of the job cannot be null")
    @Past(message = "The data of the work done must be a date in the past")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @NotNull(message = "The service done cannot be empty")
    @Enumerated(EnumType.STRING)
    @Column(name = "jobDone")
    private ServicesOffered jobDone;
    
    @NotNull(message = "The hours it took to make the job cannot be null")
    private Double hours;
    
    @NotNull(message = "The price the technician charged cannot be empty")
    private Double price;
    
    @NotNull(message = "The technician who did the work cannot be empty")
    @ManyToOne
    private Technician technician;
    
    
}
