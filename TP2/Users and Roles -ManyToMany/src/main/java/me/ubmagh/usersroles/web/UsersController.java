package me.ubmagh.usersroles.web;

import lombok.AllArgsConstructor;
import me.ubmagh.usersroles.entities.User;
import me.ubmagh.usersroles.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// web.UsersController
@RestController
@AllArgsConstructor
public class UsersController {

    private UserService userService;

    @GetMapping("/users/{username}")
    public User user(@PathVariable String username){
        User user = userService.findUserByUsername(username);
        return user;
    }

}
