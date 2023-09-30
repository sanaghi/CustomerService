package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;

@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    int type;
    String number;

//    @OneToOne(mappedBy = "number")
//    private Customer customer;

}
