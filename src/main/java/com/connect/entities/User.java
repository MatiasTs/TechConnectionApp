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
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rol",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("USER")
@Entity

public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "The name cannot be empty")
    private String name;
    @NotBlank(message = "The last name cannot be empty")
    private String lastname;
    @NotBlank(message = "The username cannot be empty")
    private String userName;

    @NotBlank(message = "The password cannot be empty")
    @Size(min = 8, message = "The password must be at least 8 characters long")
    private String password;
    
    @NotBlank(message = "The NIC cannot be empty")
    private String NIC;

    @NotNull(message = "The date of birth cannot be empty")
    @Past(message = "The date of birth must be a date in the past")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    private String imageRoute;

    @Transient
    private MultipartFile image;
    
    @NotBlank(message = "The telphone cannot be empty")
    private String phone;

    @NotNull(message = "The rol cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "user_rol")
    private Roles rol;

}
