package com.firstProject.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.firstProject.model.Customer;
import com.firstProject.firstProject.repository.CustomerRepository;
import com.firstProject.firstProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    public void createCustomer (@RequestBody Customer customer) throws JsonProcessingException {
        customerService.createCustomer(customer);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{customerId}")
    public void deleteCustomerById(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/all")
    public List <Customer> getAllCustomerByFirstName(@RequestParam String firstName){
        return customerService.getAllCustomersByFirstName(firstName);
    }

    @GetMapping("/allIds")
    public List<Long> getAllCustomerIdsByFirstName(@RequestParam String firstName){
        return customerService.getAllCustomerIdsByFirstName(firstName);
    }
}
