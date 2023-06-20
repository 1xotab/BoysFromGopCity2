package com.example.boysfromgopcity.service;

import com.example.boysfromgopcity.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    void addCustomer(Customer customer);

    Optional<Customer> getCustomerById(Long id);

    List<Customer> getAllCustomers();

    void updateTransfer(Long id, Customer customer);

    void deleteCustomerById(Long id);
}
