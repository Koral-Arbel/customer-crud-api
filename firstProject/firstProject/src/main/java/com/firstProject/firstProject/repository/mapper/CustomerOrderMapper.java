package com.firstProject.firstProject.repository.mapper;

import com.firstProject.firstProject.model.CustomerOrder;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class CustomerOrderMapper implements RowMapper<CustomerOrder> {
    @Override
    public CustomerOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerOrder customerOrder = new CustomerOrder(
                rs.getLong("id"),
                rs.getLong("customer_id"),
                rs.getString("item_name"),
                rs.getDouble("price")
        );
        return customerOrder;
    }
}
