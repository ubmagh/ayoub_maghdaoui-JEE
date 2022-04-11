package me.ubmagh.apgestionetudiants.repositories;

import me.ubmagh.apgestionetudiants.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, String> {

}
