package com.example.boysfromgopcity.controller;

import com.example.boysfromgopcity.entity.Customer;
import com.example.boysfromgopcity.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/home")
public class MainController {

    private final CustomerService customerService;

    @GetMapping(path = "hello")
    public String sayHello() {

        return "Hello world!";
    }

    @GetMapping(path = "customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "test")
    public String test() {

        return "1337";
    }


}
