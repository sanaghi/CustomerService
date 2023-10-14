package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer roleId;
    private  String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
