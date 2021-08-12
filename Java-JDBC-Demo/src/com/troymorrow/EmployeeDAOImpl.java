package com.troymorrow;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    private static Statement statement = null;
    Connection connection = null;
    public EmployeeDAOImpl()  {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "insert into employee (name, email) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("Employee saved");
        else
            System.out.println("Oops! something went wrong");
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "update employee set name = ?, email = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setInt(3, employee.getId());
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("Employee updated");
        else
            System.out.println("Oops! something went wrong");
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "delete from employee where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("Employee deleted");
        else
            System.out.println("Oops! something went wrong");
    }

    @Override
    public void startTranscation() throws SQLException {
        String sql = "start transaction";
        PreparedStatement ps  = connection.prepareStatement(sql);
        ps.execute(sql);

    }

    @Override
    public void commitTransaction() throws SQLException {
        String sql = "commit";
        PreparedStatement ps  = connection.prepareStatement(sql);
        ps.execute(sql);

    }

    @Override
    public void rollbackTransaction() throws SQLException {
        String sql = "rollback";
        PreparedStatement ps  = connection.prepareStatement(sql);
        ps.execute(sql);

    }

    @Override
    public List<Employee> getEmployee() throws SQLException {
        String sql = "select * from employee";
        List<Employee> employee = new ArrayList<>();
        statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        while (resultset.next()){
            int id = resultset.getInt(1);
            String name = resultset.getString(2);
            String email = resultset.getString(3);

            Employee emp = new Employee(id,name,email);
            employee.add(emp);
        }
        return employee;

    }

    @Override
    public Employee employeeById(int empId) throws SQLException {
        Employee employee = new Employee();
        String sql = "select * from employee where id = " + empId;
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();

        if (resultSet != null) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            employee = new Employee(id, name, email);
        } else {
            System.out.println("no record found");
        }
        return employee;
    }
}
