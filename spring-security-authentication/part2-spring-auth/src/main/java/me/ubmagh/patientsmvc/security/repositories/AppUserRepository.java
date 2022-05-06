package me.ubmagh.patientsmvc.security.repositories;

import me.ubmagh.patientsmvc.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {

    AppUser findByUsername( String username);

}
