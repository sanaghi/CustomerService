package az.lesson.spring.customerservice.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
@Data
@Entity
//@Table(name= "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;


    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private  Person person;

    @ManyToOne
    @JoinColumn (name ="type_id",referencedColumnName = "id")
    private  CustomerType type;

    private  double debt;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")

    private Address address;




//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn (name = "address_id",referencedColumnName = "id")
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "customeraddressrel",
//            joinColumns =
//            {@JoinColumn(name = "customer_id",referencedColumnName = "id")},
//            inverseJoinColumns =
//            {@JoinColumn(name = "address_id",referencedColumnName = "id")}
//    )
//    private Address address;



    @ManyToMany
    @JoinTable(
            name = "customer_saved_card",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "saved_card_id")
    )
    private Set<SavedCard> savedCards;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "number", referencedColumnName = "id")
    private PhoneNumber number;



    public Customer() {
    }

    public Customer(long id, String finCode, Address address, CustomerType type, double dept) {
        this.id = id;
//        this.finCode = finCode;
//        this.address = address;
        this.type = type;
        this.debt = dept;
        log.info(" Customer constructor created");
    }


    public Customer(String finCode, Address address, CustomerType type, double dept) {
//        this.finCode = finCode;
//        this.address = address;
        this.type = type;
        this.debt = dept;
    }

}

