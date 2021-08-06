package com.troymorrow.sqlconnector;

import java.sql.SQLException;
import java.util.List;

public interface DAOCustomer {
    void addCustomer(Customer customer) throws SQLException;
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
    List<Customer> getCustomer();
    Customer getCustomerByID (int id);

}
