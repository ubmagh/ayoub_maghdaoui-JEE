package me.ubmagh.patientsmvc.security.service;

import me.ubmagh.patientsmvc.security.entities.AppRole;
import me.ubmagh.patientsmvc.security.entities.AppUser;

public interface SecurityService {

    AppUser saveNewUser( String username, String password, String verifyPassword);
    AppRole saveNewRole( String roleName, String description);
    void addRoleToUser( String username, String roleName);
    void removeRoleFromUser( String username, String roleName);
    AppUser loadUserByUsername( String username );

}
