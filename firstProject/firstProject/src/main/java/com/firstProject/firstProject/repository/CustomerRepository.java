package com.firstProject.firstProject.repository;

import com.firstProject.firstProject.model.Customer;
import com.firstProject.firstProject.model.CustomerStatus;

import java.util.List;

public interface CustomerRepository {
    Long createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);

    Customer getCustomerById(Long id);
    List<Customer> getAllCustomersByFirstName(String firstName);
    List<Long> getAllCustomerIdsByFirstName(String firstName);
    List<Customer> getAllCustomersByStatus(CustomerStatus customerStatus);
}
