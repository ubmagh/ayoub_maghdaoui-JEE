package me.ubmagh.usersroles;

import me.ubmagh.usersroles.entities.Role;
import me.ubmagh.usersroles.entities.User;
import me.ubmagh.usersroles.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) { SpringApplication.run(JpaApplication.class, args); }

    @Bean
    public CommandLineRunner Start(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                User u1 = new User();
                u1.setUsername("ayoub");
                u1.setPassword(" plainPassword :D ");
                userService.addNewUser( u1 );
                User u2 = new User();
                u2.setUsername("admin");
                u2.setPassword(" another plainPassword :D ");
                userService.addNewUser( u2 );


                Stream.of( "STUDENT", "USER", "ADMIN").forEach( r->{
                    Role role1 = new Role( null, r, "any", null);
                    userService.addNewRole( role1 );
                });

                userService.addRoleToUser( "ayoub", "USER");
                userService.addRoleToUser( "ayoub", "STUDENT");
                userService.addRoleToUser( "admin", "ADMIN");
                userService.addRoleToUser( "admin", "USER");


                try {
                    User user = userService.authenticate( "ayoub", " plainPassword :D ");
                    System.out.println( " id => "+user.getId() );
                    System.out.println( " Username => "+user.getUsername() );
                    System.out.println( " roles => " );
                    user.getRoles().forEach( r->{
                        System.out.println( " \t  -> "+ r.toString() );
                    });
                    System.out.println(" ==> authenticated successfully !!");

                }catch (Exception exc){
                    System.out.println(" ==> Cannot authenticate !!");
                }

            }
        };
    }

    /*

        either JpaApplication extends CommandLineRunner
        or create a function with @Bean that returns CommandeLine Runner

     */


    /*
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
     */

}
