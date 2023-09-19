package com.firstProject.firstProject.controller;


import com.firstProject.firstProject.model.Order;
import com.firstProject.firstProject.model.OrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class FirstProjectController {

    private ArrayList<Order> orders = new ArrayList<>();
    private Long nextOrderId = 0L;

    Logger logger = LoggerFactory.getLogger(FirstProjectController.class);

    @GetMapping("/order/{orderId}/item/{itemId}")
    public String getOrderById(@RequestHeader("apiToken") String apiToken, @PathVariable Integer orderId, @PathVariable Integer itemId){
        logger.info("Got new orderId request with order id: " + orderId + " and item id: " + itemId);
        logger.info("Got header key with key name: apiToken with value: " + apiToken);
        return "You requested to get order with order id: " + orderId + " and item id: " + itemId;
    }

    @PostMapping("/student/")
    public String getStudentByName(@RequestBody String studentId){
        logger.info("Got request for student with name: " + studentId);
        return "You requested to get student with name: " + studentId;
    }

    @GetMapping("/orders")
    public ArrayList<Order> getOrders(){
        return orders;
    }

    @PostMapping("/order")
    public Order createOrders(@RequestBody OrderRequest orderRequest) {
        logger.info("Creating new order for customer name: " + orderRequest.getCustomerName() + " with item: "
                + orderRequest.getItem().getName() + " and price: " + orderRequest.getItem().getPrice());
        Order orderToCreate = new Order(nextOrderId, orderRequest.getCustomerName(), orderRequest.getItem());
        orders.add(orderToCreate);
        nextOrderId++;
        return orderToCreate;
    }

    //example nested object
    @PostMapping("/orders")
    public String createOrder(@RequestBody OrderRequest orderRequest){
        logger.info("Creating new order for customer name: " + orderRequest.getItem().getName() + "with item: " + orderRequest.getItem().getPrice() + " and price: " + orderRequest.getItem().getPrice());

        return "Creating new order for customer name: " + orderRequest.getCustomerName() + "with item: " + orderRequest.getItem().getName() + " and price: " + orderRequest.getItem().getPrice();

    }
}