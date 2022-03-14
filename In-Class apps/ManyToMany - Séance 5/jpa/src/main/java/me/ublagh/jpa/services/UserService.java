package me.ublagh.jpa.services;

import me.ublagh.jpa.entities.Role;
import me.ublagh.jpa.entities.User;

public interface UserService {

    User addNewUser(User user);
    Role addNewRole( Role role);
    User findUserByUsername( String username);
    Role findRoleByRoleName( String roleName);
    void addRoleToUser( Role role, User user);
    void addRoleToUser( String username, String roleName);

    public User authenticate( String username, String password);

}
