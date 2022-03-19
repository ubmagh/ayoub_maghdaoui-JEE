package me.ubmagh.hospital.repositories;

import me.ubmagh.hospital.entities.Medecin;
import me.ubmagh.hospital.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

// repositories.PatientRepository
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByFname(String nom);

    public List<Patient> findBySick(Boolean m);

    public List<Patient> findByFnameOrLname( String fname, String lname);

    public List<Patient> findByScoreLessThan( int score);

    public Page findByFnameContains(String searchable, Pageable pageable);

    public List<Patient> findByBirthDateBetweenAndSickAndScoreGreaterThanAndFnameContains(Date d1, Date d2, boolean b, int scoreMin, String fnameSearchable);

    // these kind of functions can get so long
    // one of the solutions is to use explicite HQL Queries
    @Query("SELECT p FROM Patient p WHERE p.birthDate BETWEEN :d1 AND :d2 AND p.sick = :b AND p.score > :scoreMin AND p.fname like :fnameSearchable")
    public List<Patient> JustFindWhatIWant( @Param("d1") Date d1, @Param("d2") Date d2, @Param("b") boolean b, @Param("scoreMin") int scoreMin, @Param("fnameSearchable") String fnameSearchable );

}
