package az.lesson.spring.customerservice.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Entity
//@Table(name= "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String finCode;
    private  String address;
    private  int type;
    private  double debt;

    public Customer() {
    }

    public Customer(long id, String finCode, String address, int type, double dept) {
        this.id = id;
        this.finCode = finCode;
        this.address = address;
        this.type = type;
        this.debt = dept;
        log.info(" Customer constructor created");
    }


    public Customer(String finCode, String address, int type, double dept) {
        this.finCode = finCode;
        this.address = address;
        this.type = type;
        this.debt = dept;
    }
}

