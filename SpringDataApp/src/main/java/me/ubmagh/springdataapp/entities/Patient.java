package me.ubmagh.springdataapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String fname;
    @Column(length = 100)
    private String lname;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private int score;
    private boolean bo;


}
