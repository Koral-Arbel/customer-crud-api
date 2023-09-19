package com.firstProject.firstProject.model;

import java.util.List;

public class CustomerOrder {
    private Long id;
    private Long customerId;
    private String itemName;
    private Double price;
    public CustomerOrder(){}

    public CustomerOrder(Long id, Long customerId, String itemName, Double price) {
        this.id = id;
        this.customerId = customerId;
        this.itemName = itemName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getItemName() {
        return itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(Double price) {
        this.price = price;

    }
    public CustomerOrderResponse toCustomerOrderResponse(Customer customer, List<CustomerOrder> customerOrderList){
        return new CustomerOrderResponse(customer, customerOrderList);
    }
}
