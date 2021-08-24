package com.troymorrow.sqlconnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOEmpImpl implements DAOEmployee{
    private static Statement statement = null;
    Connection connection = null;
    public DAOEmpImpl(){
        try {
            this.connection = Connector.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql= "insert into employee (first_name, last_name, emp_email) values (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, employee.getFirstName());
        ps.setString(2, employee.getLastName());
        ps.setString(3, employee.getEmail());
        int count = ps.executeUpdate();
        if (count > 0 )
            System.out.println("New Employee Added");
        else
            System.out.println("Incorrect Entry/Information");
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sql= "update employee set first_name = ?, last_name = ?, emp_email = ? where emp_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, employee.getFirstName());
        ps.setString(2, employee.getLastName());
        ps.setString(3, employee.getEmail());
        ps.setInt(4, employee.getId());
        int count = ps.executeUpdate();
        if (count > 0 )
            System.out.println("Employee Updated");
        else
            System.out.println("Incorrect Entry/Information");
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql= "delete from employee where emp_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        int count = ps.executeUpdate();
        if (count > 0)
            System.out.println("Employee Deleted.");
        else
            System.out.println("Incorrect Entry/Information");
    }

    @Override
    public List<Employee> getEmployee() throws SQLException {
        String sql = "select * from employee";
        List<Employee> employee = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        while (resultset.next()){
            int id = resultset.getInt(1);
            String firstName = resultset.getString(2);
            String lastName = resultset.getString(3);
            String email = resultset.getString(4);
            String username = resultset.getString(5);
            String password = resultset.getString(6);

            Employee emp = new Employee(id,firstName, lastName,email, username,  password);
            employee.add(emp);
        }
        return employee;
    }

    @Override
    public Employee getEmployeeByID(int empId) throws SQLException {
        Employee employee = new Employee();
        String sql = "select * from employee where emp_id = " + empId;
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
            employee = new Employee(id, firstName, lastName, email, username, password);
        } else {
            System.out.println("no record found");
        }
        return employee;
    }

    @Override
    public Employee getEmployeeByLogin(String username, String password) throws SQLException {
        Employee employee = new Employee();
        String sql = "select * from employee WHERE emp_username = '" + username
                + "' AND emp_password = '" + password + "'";
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
            employee = new Employee(id, firstName, lastName, email, userName, passWord);
        } else {
            System.out.println("no record found");
        }
        return employee;
    }
}
