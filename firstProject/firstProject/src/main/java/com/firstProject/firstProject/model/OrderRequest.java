package com.firstProject.firstProject.model;

public class OrderRequest {
    private String customerName;
    private Item item;
    public OrderRequest(){}

    public OrderRequest(String customerName, Item item) {
        this.customerName = customerName;
        this.item = item;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Item getItem() {
        return item;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
