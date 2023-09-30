package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    private int cityId;
    private int districtId;
    private int streetId;
    private  String addressDescription;
//    @OneToOne(mappedBy = "address" )
//    private Customer customer;
}
