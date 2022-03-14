package me.ubmagh.springdataapp;

import me.ubmagh.springdataapp.entities.Patient;
import me.ubmagh.springdataapp.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringDataAppApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception { // called automatically after main()

        System.out.println("===> Inserting Patients ...");
        patientRepository.save( new Patient( null, "ayoub", "Ahmed", new Date(), 10, false));
        patientRepository.save( new Patient( null, "ibrahim", "Ali", new Date(), 10, true));
        patientRepository.save( new Patient( null, "mahmoud", "Ali", new Date(), 10, true));

        List<Patient> patients = patientRepository.findAll();

        System.out.println("======================= \n ==> Patients List =======================");
        patients.forEach( patient -> {
            System.out.println("----------------------");
            System.out.println("  -> fname : "+patient.getFname());
            System.out.println("  -> lname : "+patient.getLname());
            System.out.println("  -> birth date : "+patient.getBirthDate());
            System.out.println("  -> score : "+patient.getScore());
            System.out.println("  -> bo : "+patient.isBo() );
        });

        System.out.println("======================= \n ==> patient with id 2 =======================");
        Patient patient = patientRepository.findById(2L).orElse(null);
        if( patient==null )
            System.out.println("-> patient not found");
        else {
            System.out.println("-> patient found : ");
            System.out.println("  -> fname : " + patient.getFname());
            System.out.println("  -> lname : " + patient.getLname());
            System.out.println("  -> birth date : " + patient.getBirthDate());
            System.out.println("  -> score : " + patient.getScore());
            System.out.println("  -> bo : " + patient.isBo());

            System.out.println("======================= \n ==> set patient score to 921 =======================");
            patient.setScore(921);
            patientRepository.save(patient);
            System.out.println("-> look for this value in the H2 db ");
        }


        System.out.println("======================= \n ==> delete patient with id 3 =======================");
        patientRepository.deleteById(3L);
        System.out.println("-> look for this value in the H2 db ");


        System.out.println("======================= \n ==> filling DB... =======================");
        for( int o =0; o<101; o++)
            patientRepository.save( new Patient( null, "ayoub"+o, "Ahmed"+o, new Date(), (int) (Math.random()), true));


        System.out.println("======================= \n ==> paginate patients data =======================");
        Page<Patient> page = patientRepository.findAll(PageRequest.of(0, 3));
        System.out.println("--> page 1 content : ");
        for ( Patient pati: page) {
            System.out.println("  -> fname : " + pati.getFname() +"  -> lname : " + pati.getLname());
        }
        page = patientRepository.findAll(PageRequest.of(2, 3));
        System.out.println("--> page 2 content : ");
        for ( Patient pati: page.getContent()) {
            System.out.println("  -> fname : " + pati.getFname() +"  -> lname : " + pati.getLname());
        }
        System.out.println("Number of pages: "+page.getTotalPages());
        System.out.println("Number of elements: "+page.getTotalElements());
        System.out.println(" current page: "+page.getNumber());


        System.out.print("\n\n ======================= \n ==> Find patients By Bo=false =======================\n result : \n");
        patients = patientRepository.findByBo(true);
        for ( Patient pati: patients ) {
            System.out.println(" "+pati.getId()+" -> fname : " + pati.getFname() +"  -> lname : " + pati.getLname());
        }

        System.out.print("\n\n ======================= \n ==> Find patients By lname=Ali OR fname='' =======================\n result : \n");
        patients = patientRepository.findByFnameOrLname("", "Ali");
        for ( Patient pati: patients ) {
            System.out.println(" "+pati.getId()+" -> fname : " + pati.getFname() +"  -> lname : " + pati.getLname());
        }


        System.out.print("\n\n ======================= \n ==> Find patients By score < 10 =======================\n result : \n");
        patients = patientRepository.findByScoreLessThan(10);
        for ( Patient pati: patients ) {
            System.out.println(" "+pati.getId()+" -> fname : " + pati.getFname() +"  -> lname : " + pati.getLname());
        }

        System.out.print("\n\n ======================= \n ==> Find patients By fname contains 'a' --> pageable (page:1, size:3) =======================\n result : \n");
        page = patientRepository.findByFnameContains("a", PageRequest.of(1, 3));
        for ( Patient pati: page.getContent() ) {
            System.out.println(" "+pati.getId()+" -> fname : " + pati.getFname() +"  -> lname : " + pati.getLname());
        }
        System.out.println(" number  of pages : "+page.getNumber()+" | total number of elements : "+page.getTotalElements());

        String today = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        String yesterDay = (LocalDate.now().minusDays(1)).format(DateTimeFormatter.ISO_DATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print("\n\n ======================= \n ==> Find patients By function findByBirthDateBetweenAndBoAndScoreGreaterThanAndFnameContains --> d1=yesterday, d2= today, b=true, scoreMin=100, fnameSearchable='a' =======================\n result : \n");
        patients = patientRepository.findByBirthDateBetweenAndBoAndScoreGreaterThanAndFnameContains( sdf.parse(yesterDay), sdf.parse(today), true, 100, "a" );
        for ( Patient pati: patients ) {
            System.out.println(" "+pati.getId()+" -> fname : " + pati.getFname() +"  -> lname : " + pati.getLname());
        }
        System.out.print("\n  ==> Find patients By function JustFindWhatIWant --> d1=yesterday, d2= today, b=true, scoreMin=100, fnameSearchable='a' =======================\n result : \n");
        patients = patientRepository.JustFindWhatIWant( sdf.parse(yesterDay), sdf.parse(today), true, 100, "%a%" );
        for ( Patient pati: patients ) {
            System.out.println(" "+pati.getId()+" -> fname : " + pati.getFname() +"  -> lname : " + pati.getLname());
        }

        System.out.println("*****************");
    }
}
