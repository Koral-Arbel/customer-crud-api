package com.firstProject.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.firstProject.model.Customer;
import com.firstProject.firstProject.model.CustomerOrder;
import com.firstProject.firstProject.model.CustomerOrderRequest;
import com.firstProject.firstProject.model.CustomerOrderResponse;
import com.firstProject.firstProject.repository.CustomerOrderRepository;
import com.firstProject.firstProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private CustomerService customerService;


    @Override
    public CustomerOrderResponse createCustomerOrder(CustomerOrderRequest customerOrderRequest) throws JsonProcessingException {
        Customer selectedCustomer = customerOrderRequest.getCustomer();
        Long createdCustomerId = customerOrderRequest.getCustomer().getId();
        if(createdCustomerId == null){
            createdCustomerId = customerService.createCustomer(selectedCustomer);
        } else {
            Customer existingCustomer = customerService.getCustomerById(selectedCustomer.getId());
            if(existingCustomer == null){
                throw new IllegalArgumentException("Can't find existing customer with customer id: " + selectedCustomer.getId());
            }
        }
        selectedCustomer = customerService.getCustomerById(createdCustomerId);
        customerOrderRequest.setCustomer(selectedCustomer);
        CustomerOrder customerOrderToCreate = customerOrderRequest.toCustomerOrder();
        customerOrderRepository.createCustomerOrder(customerOrderToCreate);
        List<CustomerOrder> customerOrders = customerOrderRepository.getAllCustomerByCustomerId(selectedCustomer.getId());
        return customerOrderToCreate.toCustomerOrderResponse(selectedCustomer, customerOrders);
    }

    @Override
    public CustomerOrderResponse updateCustomerOrderById(CustomerOrderRequest customerOrderRequest) {
//        customerOrderRepository.updateCustomerOrderById(customerOrder);
        return null;
    }

    @Override
    public void deleteCustomerOrderById(Long id) {
        customerOrderRepository.deleteCustomerOrderById(id);
    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        return customerOrderRepository.getCustomerOrderById(id);
    }
}
