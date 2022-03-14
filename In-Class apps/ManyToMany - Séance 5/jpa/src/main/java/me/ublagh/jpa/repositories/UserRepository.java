package me.ublagh.jpa.repositories;

import me.ublagh.jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // not obligatory
public interface UserRepository extends JpaRepository< User, String> {

    public User findByUsername( String username);

}
