package com.troymorrow.sqlconnector;

import java.sql.SQLException;
import java.util.List;

public interface DAOEmployee {
    void addEmployee(Employee employee) throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(int id) throws SQLException;
    List<Employee> getEmployee() throws SQLException;
    Employee getEmployeeByID (int id) throws SQLException;
    Employee getEmployeeByLogin (String username, String password) throws SQLException;
}
