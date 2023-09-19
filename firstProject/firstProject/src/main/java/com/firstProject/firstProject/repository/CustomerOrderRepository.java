package com.firstProject.firstProject.repository;

import com.firstProject.firstProject.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderRepository {
    void createCustomerOrder(CustomerOrder customerOrder);
    void updateCreateCustomerOrderById(CustomerOrder customerOrder);
    void deleteCustomerOrderById(Long id);
    CustomerOrder getCustomerOrderById(Long id);
    List<CustomerOrder> getAllCustomerByCustomerId(Long customerId);

}
