package com.firstProject.firstProject.repository;

import com.firstProject.firstProject.model.CustomerOrder;
import com.firstProject.firstProject.repository.mapper.CustomerOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerOrderRepositoryImpl implements CustomerOrderRepository {
    private static final String CUSTOMER_ORDER_TABLE_NAME = "customer_order";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CustomerOrderMapper customerOrderMapper;

    @Override
    public void createCustomerOrder(CustomerOrder customerOrder) {
        String sql = "INSERT INTO " + CUSTOMER_ORDER_TABLE_NAME + " " + "(customer_id, item_name, price) values (?, ?, ?)";
        jdbcTemplate.update(
                sql,
                customerOrder.getCustomerId(),
                customerOrder.getItemName(),
                customerOrder.getPrice()
        );
    }

    @Override
    public void updateCreateCustomerOrderById(CustomerOrder customerOrder) {
        String sql = "UPDATE " + CUSTOMER_ORDER_TABLE_NAME + "SET customer_id=?, item_name=?, price=? WHERE id=?";
        jdbcTemplate.update(
                sql,
                customerOrder.getCustomerId(),
                customerOrder.getItemName(),
                customerOrder.getPrice(),
                customerOrder.getId()
        );
    }

    @Override
    public void deleteCustomerOrderById(Long id) {
        String sql = "DELETE FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        String sql = "SELECT * FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE status = ?";
        try {
            return jdbcTemplate.queryForObject(sql, customerOrderMapper, id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Empty Data Warning");
            return null;
        }
    }

    @Override
    public List<CustomerOrder> getAllCustomerByCustomerId(Long customerId) {
        String sql = "SELECT * FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE customer_id=?";
        try{
            return jdbcTemplate.query(sql, customerOrderMapper, customerId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Empty Data Waring");
            return null;
        }
    }
}
