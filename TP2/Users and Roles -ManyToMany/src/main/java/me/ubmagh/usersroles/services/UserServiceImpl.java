package me.ubmagh.usersroles.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.AllArgsConstructor;
import me.ubmagh.usersroles.entities.Role;
import me.ubmagh.usersroles.entities.User;
import me.ubmagh.usersroles.repositories.RoleRepository;
import me.ubmagh.usersroles.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;


    // using constructor injection cuz @Autowired is not recommended
    /* // Define One single constructor with params to enable injection in constructor
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
     */ // commented cuz it's replaced with @AllArgsConstructor annotation

    @Override
    public User addNewUser(User user) {
        user.setId( UUID.randomUUID().toString() );
        // hash password
        user.setPassword( BCrypt.withDefaults().hashToString(10, user.getPassword().toCharArray() ));
        return userRepository.save( user );
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save( role );
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername( username );
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName( roleName);
    }

    @Override
    public void addRoleToUser(Role role, User user) {
        user.getRoles().add( role );
        userRepository.save( user );
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUsername( username );
        Role role = findRoleByRoleName( roleName );
        if( user.getRoles() == null )
            throw new NullPointerException();
        user.getRoles().add( role );
        role.getUsers().add( user  ); // ?
        // userRepository.save( user ); // no need cuz we have Transactional annotation
    }


    @Override
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername( username);
        if( user ==null )
            throw new RuntimeException("Bad credentiels !");
        if(  BCrypt.verifyer().verify( password.toCharArray(), user.getPassword().toCharArray()).verified )
            return user;
        throw new RuntimeException("Bad credentiels !");
    }
}
