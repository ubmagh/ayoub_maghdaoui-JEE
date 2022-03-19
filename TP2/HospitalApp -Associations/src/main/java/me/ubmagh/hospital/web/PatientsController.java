package me.ubmagh.hospital.web;

import me.ubmagh.hospital.entities.Patient;
import me.ubmagh.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientsController  {

    @Autowired
    PatientRepository patientRepository;


    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

}
