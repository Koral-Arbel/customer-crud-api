package com.firstProject.firstProject.model;

public class Order {
    private Long id;
    private String customerName;
    private Item item;

    public Order(Long id, String customerName, Item item) {
        this.id = id;
        this.customerName = customerName;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Item getItem() {
        return item;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
