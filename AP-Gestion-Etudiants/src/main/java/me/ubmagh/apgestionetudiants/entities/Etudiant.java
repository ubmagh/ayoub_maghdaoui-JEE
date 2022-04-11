package me.ubmagh.apgestionetudiants.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Etudiant {

    @Id
    private String id;
    private String nom;
    private String prenom;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Enumerated(EnumType.STRING)
    private GenresEnum genre;

    private boolean enRegle;

}
