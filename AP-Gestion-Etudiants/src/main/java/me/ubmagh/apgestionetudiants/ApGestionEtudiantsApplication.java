package me.ubmagh.apgestionetudiants;

import me.ubmagh.apgestionetudiants.entities.Etudiant;
import me.ubmagh.apgestionetudiants.entities.GenresEnum;
import me.ubmagh.apgestionetudiants.helpers.HelperFunctions;
import me.ubmagh.apgestionetudiants.services.EtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class ApGestionEtudiantsApplication {


    @Autowired
    EtudiantServiceImpl etudiantService;


    public static void main(String[] args) {
        SpringApplication.run(ApGestionEtudiantsApplication.class, args);
    }


    // @Bean
    CommandLineRunner runner (){
        return args -> {
            Etudiant et1 = new Etudiant( null, "MAGHDAOUI", "Ayoub", "ayoub@ayoub.me", HelperFunctions.parseDate("2000-06-01"), GenresEnum.MASCULIN, false),
                    et2 = new Etudiant( null, "ALLAT", "Mouad", "mouad@mouad.me", HelperFunctions.parseDate("2000-01-01"), GenresEnum.MASCULIN, true),
                    et3 = new Etudiant( null, "GHalbz", "Hassan", "ayoub@ayoub.me", HelperFunctions.parseDate("2000-04-01"), GenresEnum.MASCULIN, false);

            Stream.of( et1, et2, et3).forEach( et-> etudiantService.createEtudiant(et) );

        };
    }

}
