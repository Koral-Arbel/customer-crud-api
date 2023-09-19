package com.firstProject.firstProject.model;

import java.util.List;

public class CustomerOrderResponse {
    private Customer customer;
    private List<CustomerOrder> customerOrderList;

    private CustomerOrderResponse(){}

    public CustomerOrderResponse(Customer customer, List<CustomerOrder> customerOrderList) {
        this.customer = customer;
        this.customerOrderList = customerOrderList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerOrderList(List<CustomerOrder> customerOrderList) {
        this.customerOrderList = customerOrderList;
    }

}
