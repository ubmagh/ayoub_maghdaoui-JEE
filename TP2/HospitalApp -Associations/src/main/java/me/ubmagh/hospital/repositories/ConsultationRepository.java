package me.ubmagh.hospital.repositories;

import me.ubmagh.hospital.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// repositories.ConsultationRepository
@Repository
public interface ConsultationRepository extends JpaRepository< Consultation, Long> {


 }
