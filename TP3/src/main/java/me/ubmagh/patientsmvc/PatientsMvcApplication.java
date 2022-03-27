package me.ubmagh.patientsmvc;

import me.ubmagh.patientsmvc.entities.Patient;
import me.ubmagh.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner start( PatientRepository patientRepository){
        return args -> {
            /*
            Stream.of("Ahmed", "Ayoub", "Ali", "Fatima", "Hassan", "hanane", "mohamed", "yusuf", "yassamine", "amine", "ayman", "lahcen", "naoufal", "mouad").forEach(s -> {
                Patient p = new Patient( null, s, new Date(), false, 10);
                patientRepository.save( p );
            });


            patientRepository.findAll().forEach(patient -> {
                System.out.println(patient);
            });
             */

        };
    }
}
