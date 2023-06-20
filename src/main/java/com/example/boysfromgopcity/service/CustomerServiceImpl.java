package com.example.boysfromgopcity.service;

import com.example.boysfromgopcity.entity.Customer;
import com.example.boysfromgopcity.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerRepository.findAll());
    }

    @Override
    public void updateTransfer(Long id, Customer customer) {
        Customer exitingCustomer = customerRepository.findById(id).orElseThrow(RuntimeException::new);
        exitingCustomer.setName(customer.getName());
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
