package me.ubmagh.hospital.repositories;

import me.ubmagh.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// repositories.RendezVousRepository
@Repository
public interface RendezVousRepository extends JpaRepository< RendezVous, String> {
}
