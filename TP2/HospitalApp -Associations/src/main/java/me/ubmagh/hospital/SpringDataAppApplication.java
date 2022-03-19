package me.ubmagh.hospital;

import me.ubmagh.hospital.entities.*;
import me.ubmagh.hospital.repositories.ConsultationRepository;
import me.ubmagh.hospital.repositories.MedecinRepository;
import me.ubmagh.hospital.repositories.PatientRepository;
import me.ubmagh.hospital.repositories.RendezVousRepository;
import me.ubmagh.hospital.services.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;


@SpringBootApplication
public class SpringDataAppApplication {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(me.ubmagh.hospital.SpringDataAppApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            /*
            PatientRepository patientRepository,
            MedecinRepository medecinRepository,
            RendezVousRepository rendezVousRepository,
            ConsultationRepository consultationRepository
             */
            MedecinRepository medecinRepository,
            IHospitalService hospitalService
        ){ // DI
        return args -> {
            patientRepository.save( new Patient( null, "ayoub", "Maghdaoui", new Date(), 100, false, null));
            Stream.of( "ahmed", "Najat", "Hassan").forEach(s -> {
                Patient p = new Patient();
                p.setFname(s);
                p.setLname(s);
                p.setScore(20);
                p.setSick(false);
                p.setBirthDate(new Date());
                // patientRepository.save(p);
                hospitalService.savePatient(p);
            });

            Random r = new Random();
            Stream.of( "Ayman", "hannan", "Mohammed").forEach( s -> {
                Medecin m = new Medecin();
                m.setNom(s);
                m.setEmail(s+"@gmail.com");
                m.setSpecialite( Stream.of("cardio", "dentiste", "generale", "optics").skip(r.nextInt(4)).findFirst().get() );
                // medecinRepository.save(m);
                hospitalService.saveMedecin(m);
            });

            Patient patient = patientRepository.findByFname("ayoub");
            Patient patient1 = patientRepository.findById(1L).orElse(null);

            Medecin medecin = medecinRepository.findByNom("Ayman");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate( new Date());
            rendezVous.setMedecin( medecin );
            rendezVous.setPatient(patient);
            rendezVous.setStatus( StatusRDV.PENDING );
            hospitalService.saveRdv( rendezVous);


            Consultation consultation = new Consultation();
            consultation.setDateConsultation( new Date());
            consultation.setRendezVous(rendezVous);
            consultation.setRapport(" Rapport de consultation ..................;");
            hospitalService.saveConsultation(consultation);




        };
    }
}

/*

// playing with patient entity
@SpringBootApplication
public class SpringDataAppApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception { // called automatically after main()

        System.out.println("===> Insertion des Patients ...");
        patientRepository.save( new Patient( null, "ayoub", "Ahmed", new Date(), 10, false, null));
        patientRepository.save( new Patient( null, "ibrahim", "Ali", new Date(), 10, true, null));
        patientRepository.save( new Patient( null, "mahmoud", "Ali", new Date(), 10, true, null));

        List<Patient> patients = patientRepository.findAll();

        System.out.println("======================= \n ==> Liste des Patients  =======================");
        patients.forEach( patient -> {
            System.out.println("----------------------");
            System.out.println("  -> prenom : "+patient.getFname());
            System.out.println("  -> nom : "+patient.getLname());
            System.out.println("  -> date de naissance : "+patient.getBirthDate());
            System.out.println("  -> score : "+patient.getScore());
            System.out.println("  -> malade : "+patient.isSick() );
        });

        System.out.println("======================= \n ==> patient ayant l'id 2 =======================");
        Patient patient = patientRepository.findById(2L).orElse(null);
        if( patient==null )
            System.out.println("-> patient introuvable");
        else {
            System.out.println("-> patient trouvé : ");
            System.out.println("  -> prenom : " + patient.getFname());
            System.out.println("  -> nom : " + patient.getLname());
            System.out.println("  -> date de naissance : " + patient.getBirthDate());
            System.out.println("  -> score : " + patient.getScore());
            System.out.println("  -> malade : " + patient.isSick());

            System.out.println("======================= \n ==> modifier le score de patient à 921 =======================");
            patient.setScore(921);
            patientRepository.save(patient);
            System.out.println("-> vérifier la base de données, la valeur est modifiée avec succès ");
        }


        System.out.println("======================= \n ==> supprimer le patient ayant l'id 3 =======================");
        patientRepository.deleteById(3L);
        System.out.println("-> vérifier la base de données, la patient supprimé avec succès ");


        System.out.println("======================= \n ==> Remplissage de la BD avec 101 patients ... =======================");
        for( int o =0; o<101; o++)
            patientRepository.save( new Patient( null, "ayoub"+o, "Ahmed"+o, new Date(), (int) (Math.random()), true, null));


        System.out.println("======================= \n ==> paginer les patients =======================");
        Page<Patient> page = patientRepository.findAll(PageRequest.of(0, 3));
        System.out.println("--> contenu de la page 1 : ");
        for ( Patient pati: page) {
            System.out.println("  -> prenom : " + pati.getFname() +"  -> nom : " + pati.getLname());
        }
        page = patientRepository.findAll(PageRequest.of(2, 3));
        System.out.println("--> contenu de la page 2  : ");
        for ( Patient pati: page.getContent()) {
            System.out.println("  -> prenom : " + pati.getFname() +"  -> nom : " + pati.getLname());
        }
        System.out.println("nombre de pages: "+page.getTotalPages());
        System.out.println(" nombre des elements: "+page.getTotalElements());
        System.out.println(" page courante : "+page.getNumber());


        System.out.print("\n\n ======================= \n ==> trouver les patients ayant  malade=false =======================\n result : \n");
        patients = patientRepository.findBySick(true);
        for ( Patient pati: patients ) {
            System.out.println(" "+pati.getId()+" -> prenom : " + pati.getFname() +"  -> nom : " + pati.getLname());
        }

        System.out.print("\n\n ======================= \n ==> trouver les patients ayant nom=Ali OU prenom='' =======================\n result : \n");
        patients = patientRepository.findByFnameOrLname("", "Ali");
        for ( Patient pati: patients ) {
            System.out.println(" "+pati.getId()+" -> prenom : " + pati.getFname() +"  -> nom : " + pati.getLname());
        }


        System.out.print("\n\n ======================= \n ==> trouver les patients ayant le score < 10 =======================\n result : \n");
        patients = patientRepository.findByScoreLessThan(10);
        for ( Patient pati: patients ) {
            System.out.println(" "+pati.getId()+" -> prenom : " + pati.getFname() +"  -> nom : " + pati.getLname());
        }

        System.out.print("\n\n ======================= \n ==> les patients ayant un prenom qui contient 'a' page 1 --> pageable (page:1, size:3) =======================\n result : \n");
        page = patientRepository.findByFnameContains("a", PageRequest.of(1, 3));
        for ( Patient pati: page.getContent() ) {
            System.out.println(" "+pati.getId()+" -> fname : " + pati.getFname() +"  -> lname : " + pati.getLname());
        }
        System.out.println(" nombre de pages : "+page.getNumber()+" |  nombre total des elements : "+page.getTotalElements());

        String today = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        String yesterDay = (LocalDate.now().minusDays(1)).format(DateTimeFormatter.ISO_DATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print("\n\n ======================= \n ==> Trouver les patient par la fonction findByBirthDateBetweenAndBoAndScoreGreaterThanAndFnameContains --> d1=yesterday, d2= today, b=true, scoreMin=100, fnameSearchable='a' =======================\n result : \n");
        patients = patientRepository.findByBirthDateBetweenAndSickAndScoreGreaterThanAndFnameContains( sdf.parse(yesterDay), sdf.parse(today), true, 100, "a" );
        for ( Patient pati: patients ) {
            System.out.println(" "+pati.getId()+" -> prenom : " + pati.getFname() +"  -> nom : " + pati.getLname());
        }
        System.out.print("\n  ==> Trouver les patients par la fonction JustFindWhatIWant --> d1=yesterday, d2= today, b=true, scoreMin=100, fnameSearchable='a' =======================\n result : \n");
        patients = patientRepository.JustFindWhatIWant( sdf.parse(yesterDay), sdf.parse(today), true, 100, "%a%" );
        for ( Patient pati: patients ) {
            System.out.println(" "+pati.getId()+" -> prenom : " + pati.getFname() +"  -> nom : " + pati.getLname());
        }

        System.out.println("*****************");
    }
}
*/