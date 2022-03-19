package me.ubmagh.hospital.repositories;

import me.ubmagh.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedecinRepository extends JpaRepository< Medecin, Long> {

    Medecin findByNom( String nom);

}
