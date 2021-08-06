package com.troymorrow.sqlconnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DAOCustImpl implements DAOCustomer{
    private static Statement statment = null;
    Connection connection = null;
    public DAOCustImpl(){
        try {
            this.connection = Connector.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        String sql= "";
        PreparedStatement ps = connection.prepareStatement(sql);

    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(int id) {

    }

    @Override
    public List<Customer> getCustomer() {
        return null;
    }

    @Override
    public Customer getCustomerByID(int id) {
        return null;
    }
}
