package me.ubmagh.springdataapp.repositories;

import me.ubmagh.springdataapp.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    public List<Patient> findByBo(Boolean m);

    public List<Patient> findByFnameOrLname( String fname, String lname);

    public List<Patient> findByScoreLessThan( int score);

    public Page findByFnameContains(String searchable, Pageable pageable);

    public List<Patient> findByBirthDateBetweenAndBoAndScoreGreaterThanAndFnameContains(Date d1, Date d2, boolean b, int scoreMin, String fnameSearchable);

    // these kind of functions can get so long
    // one of the solutions is to use explicite HQL Queries
    @Query("SELECT p FROM Patient p WHERE p.birthDate BETWEEN :d1 AND :d2 AND p.bo = :b AND p.score > :scoreMin AND p.fname like :fnameSearchable")
    public List<Patient> JustFindWhatIWant( @Param("d1") Date d1, @Param("d2") Date d2, @Param("b") boolean b, @Param("scoreMin") int scoreMin, @Param("fnameSearchable") String fnameSearchable );

}
