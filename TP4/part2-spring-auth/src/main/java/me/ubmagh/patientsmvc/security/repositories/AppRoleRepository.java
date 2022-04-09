package me.ubmagh.patientsmvc.security.repositories;

import me.ubmagh.patientsmvc.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

    AppRole findByRoleName( String roleName);

}
