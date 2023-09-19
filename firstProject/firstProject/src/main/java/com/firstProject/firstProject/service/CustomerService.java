package com.firstProject.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.firstProject.model.Customer;

import java.util.List;

public interface CustomerService {
    Long createCustomer(Customer customer) throws JsonProcessingException;
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomersByFirstName(String firstName);
    List<Long> getAllCustomerIdsByFirstName(String firstName);

}
