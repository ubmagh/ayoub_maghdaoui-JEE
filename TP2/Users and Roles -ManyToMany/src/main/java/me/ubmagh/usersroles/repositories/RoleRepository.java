package me.ubmagh.usersroles.repositories;

import me.ubmagh.usersroles.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// repositories.RoleRepository
@Repository // component of DAO layer // not obligatory
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findRoleByRoleName( String roleName);

}
