package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;


}
