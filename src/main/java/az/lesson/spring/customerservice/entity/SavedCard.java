package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class SavedCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private  String cardNumber;
    private  String cardExpireDate;
    private  int cvv;

    @ManyToMany(mappedBy = "savedCards")
    private Set<Customer> customers;

}
