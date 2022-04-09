package me.ubmagh.patientsmvc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

// entities.Patient
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor // already generated with @Data but it is protected !
public class Patient {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min=3, max = 50)

    private String nom;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Past
    private Date dateNaissance;

    private boolean malade;

    @DecimalMin("0")
    @DecimalMax("1000")
    private int score;
}
