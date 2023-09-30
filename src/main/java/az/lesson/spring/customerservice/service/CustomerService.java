package az.lesson.spring.customerservice.service;


import az.lesson.spring.customerservice.entity.Address;
import az.lesson.spring.customerservice.entity.Customer;
import az.lesson.spring.customerservice.repository.AddressRepository;
import az.lesson.spring.customerservice.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    EntityManager entityManager;
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    @Autowired
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        Address address = new Address();
        address.setCityId(1212);
        Address address1 = addressRepository.save(address);

//        customer.setAddress(address1);
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
//            customer.setAddress(updatedCustomer.getAddress());
//            customer.setFinCode(updatedCustomer.getFinCode());
            customer.setType(updatedCustomer.getType());
            customer.setDebt(updatedCustomer.getDebt());

            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
