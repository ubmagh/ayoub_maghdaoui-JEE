package me.ubmagh.usersroles.services;

import me.ubmagh.usersroles.entities.Role;
import me.ubmagh.usersroles.entities.User;

// services.UserService
public interface UserService {

    User addNewUser(User user);
    Role addNewRole( Role role);
    User findUserByUsername( String username);
    Role findRoleByRoleName( String roleName);
    void addRoleToUser( Role role, User user);
    void addRoleToUser( String username, String roleName);

    public User authenticate( String username, String password);

}
