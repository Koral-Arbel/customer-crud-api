package com.firstProject.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.firstProject.model.CustomerOrder;
import com.firstProject.firstProject.model.CustomerOrderRequest;
import com.firstProject.firstProject.model.CustomerOrderResponse;
import com.firstProject.firstProject.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerOrder")
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping("/create")
    public CustomerOrderResponse createCustomerOrder(@RequestBody CustomerOrderRequest customerOrderRequest) throws JsonProcessingException {
        return customerOrderService.createCustomerOrder(customerOrderRequest);
    }

    @PutMapping("/update")
    public CustomerOrderResponse updateCustomerOrder(@RequestBody CustomerOrderRequest customerOrderRequest){
        customerOrderService.updateCustomerOrderById(customerOrderRequest);
        return null;
    }

    @DeleteMapping("/delete/{customerId}")
    public void deleteCustomerById(@PathVariable Long customerOrderId) {
        customerOrderService.deleteCustomerOrderById(customerOrderId);
    }

    @GetMapping("/{customerId}")
    public CustomerOrder getCustomerOrderById(@PathVariable Long customerOrderId) {
        return customerOrderService.getCustomerOrderById(customerOrderId);
    }
}
