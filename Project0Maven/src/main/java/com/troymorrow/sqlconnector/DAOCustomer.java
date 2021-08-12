package com.troymorrow.sqlconnector;

import java.sql.SQLException;
import java.util.List;

public interface DAOCustomer {
    void addCustomer(Customer customer) throws SQLException;
    void updateCustomer(Customer customer) throws SQLException;
    void deleteCustomer(int id) throws SQLException;
    List<Customer> getCustomer() throws SQLException;
    Customer getCustomerByID (int id) throws SQLException;
    Customer getCustomerByLogin(String username, String password) throws SQLException;

}
