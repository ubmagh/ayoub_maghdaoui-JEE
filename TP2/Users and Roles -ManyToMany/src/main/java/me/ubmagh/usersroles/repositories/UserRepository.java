package me.ubmagh.usersroles.repositories;

import me.ubmagh.usersroles.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // not obligatory
public interface UserRepository extends JpaRepository< User, String> {

    public User findByUsername( String username);

}
