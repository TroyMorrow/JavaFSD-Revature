package com.troymorrow.sqlconnector;

import java.sql.*;
import java.util.ArrayList;
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
        String sql= "insert into customers (first_name, last_name, email, username, password) values (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, customer.getFirstName());
        ps.setString(2, customer.getLastName());
        ps.setString(3, customer.getEmail());
        ps.setString(4, customer.getUsername());
        ps.setString(5, customer.getPassword());
        int count = ps.executeUpdate();
        if (count > 0 )
            System.out.println("New Customer Added");
        else
            System.out.println("Incorrect Entry/Information");

    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        String sql= "update customers set first_name = ?, last_name = ?, email = ? where cust_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, customer.getFirstName());
        ps.setString(2, customer.getLastName());
        ps.setString(3, customer.getEmail());
        ps.setInt(4, customer.getId());
        int count = ps.executeUpdate();
        if (count > 0 )
            System.out.println("Customer Updated");
        else
            System.out.println("Incorrect Entry/Information");
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        String sql= "delete from customers where cust_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        int count = ps.executeUpdate();
        if (count > 0)
            System.out.println("Customer Deleted.");
        else
            System.out.println("Incorrect Entry/Information");

    }

    @Override
    public List<Customer> getCustomer() throws SQLException {
        String sql = "select * from customers";
        List<Customer> customer = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        while (resultset.next()){
            int id = resultset.getInt(1);
            String firstName = resultset.getString(2);
            String lastName = resultset.getString(3);
            String email = resultset.getString(4);
            String username = resultset.getString(5);
            String password = resultset.getString(6);

            Customer cust = new Customer(id,firstName, lastName,email, username, password);
            customer.add(cust);
        }
        return customer;
    }

    @Override
    public Customer getCustomerByID(int custId) throws SQLException {
        Customer customer = new Customer();
        String sql = "select * from customers where cust_id = " + custId;
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();

        if (resultSet != null) {
            int id = resultSet.getInt(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String email = resultSet.getString(4);
            String username = resultSet.getString(5);
            String password = resultSet.getString(6);
            customer = new Customer(id, firstName, lastName, email, username, password);
        } else {
            System.out.println("no record found");
        }
        return customer;
    }

    @Override
    public Customer getCustomerByLogin(String username, String password) throws SQLException {
        Customer customer = new Customer();
        String sql = "select * from customers WHERE cust_username = '" + username
                + "' AND cust_password = '" + password + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();

        if (resultSet != null) {
            int id = resultSet.getInt(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String email = resultSet.getString(4);
            String userName = resultSet.getString(5);
            String passWord = resultSet.getString(6);
            customer = new Customer(id, firstName, lastName, email, userName, passWord);
        } else {
            System.out.println("no record found");
        }
        return customer;
    }
}
