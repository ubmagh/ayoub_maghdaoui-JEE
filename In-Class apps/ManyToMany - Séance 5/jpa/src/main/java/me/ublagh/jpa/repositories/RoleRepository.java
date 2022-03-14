package me.ublagh.jpa.repositories;

import me.ublagh.jpa.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // component of DAO layer // not obligatory
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findRoleByRoleName( String roleName);


}
