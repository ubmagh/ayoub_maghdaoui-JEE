package me.ubmagh.patientsmvc;

import me.ubmagh.patientsmvc.entities.Patient;
import me.ubmagh.patientsmvc.repositories.PatientRepository;
import me.ubmagh.patientsmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    // @Bean
    // be aware of @Past validation in Patient entity
    CommandLineRunner start( PatientRepository patientRepository){
        return args -> {

            // verify these inserted lines, they could violate patient entity validation rules

            Stream.of("Ahmed", "Ayoub", "Ali", "Fatima", "Hassan", "hanane", "mohamed", "yusuf", "yassamine", "amine", "ayman", "lahcen", "naoufal", "mouad").forEach(s -> {
                Patient p = new Patient( null, s, new Date(), false, 10);
                patientRepository.save( p );
            });

            /*
                // current users
                admin:12345
                user:12345
             */


            patientRepository.findAll().forEach(patient -> {
                System.out.println(patient);
            });

        };
    }

    // @Bean
    CommandLineRunner saveUsers( SecurityService securityService){
        return args -> {
            securityService.saveNewUser("ayoub","12345", "12345");
            securityService.saveNewUser("hassan","12345", "12345");
            securityService.saveNewUser("amine","12345", "12345");

            securityService.saveNewRole( "USER", "Simple user !");
            securityService.saveNewRole( "ADMIN", "The ADMIN user !");

            securityService.addRoleToUser( "ayoub", "ADMIN");
            securityService.addRoleToUser( "hassan", "USER");
            securityService.addRoleToUser( "amine", "USER");


        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
