package me.ubmagh.patientsmvc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
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
    private String nom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private boolean malade;
    private int score;
}
