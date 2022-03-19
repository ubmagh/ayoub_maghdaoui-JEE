package me.ubmagh.usersroles.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


// entities.user
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users") // this is not obligatory, but when pay attention sometimes classNames could be keywords of sql like 'groupe' => you should rename the table
public class User {

    @Id
    private String id;
    @Column( unique = true, length = 20)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany( mappedBy = "users", fetch = FetchType.EAGER) // either put mapedBy here or on Role Class
    private List<Role> roles = new ArrayList<Role>();


}
