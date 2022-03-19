package me.ubmagh.hospital.services;

import me.ubmagh.hospital.entities.Consultation;
import me.ubmagh.hospital.entities.Medecin;
import me.ubmagh.hospital.entities.Patient;
import me.ubmagh.hospital.entities.RendezVous;

public interface IHospitalService {

    Patient savePatient( Patient patient);

    Medecin saveMedecin( Medecin medecin);

    RendezVous saveRdv( RendezVous rendezVous);

    Consultation saveConsultation( Consultation consultation);


}
