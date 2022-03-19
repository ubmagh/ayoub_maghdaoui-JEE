package me.ubmagh.hospital.services;

import lombok.AllArgsConstructor;
import me.ubmagh.hospital.entities.Consultation;
import me.ubmagh.hospital.entities.Medecin;
import me.ubmagh.hospital.entities.Patient;
import me.ubmagh.hospital.entities.RendezVous;
import me.ubmagh.hospital.repositories.ConsultationRepository;
import me.ubmagh.hospital.repositories.MedecinRepository;
import me.ubmagh.hospital.repositories.PatientRepository;
import me.ubmagh.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class IHospitalServiceImpl implements IHospitalService {

    PatientRepository patientRepository;
    MedecinRepository medecinRepository;
    ConsultationRepository consultationRepository;
    RendezVousRepository rendezVousRepository;


    /*

        in this service we  could place business logic like checking if 'medecin' is available ....

     */

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRdv(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
