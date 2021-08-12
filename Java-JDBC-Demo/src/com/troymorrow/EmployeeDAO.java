package com.troymorrow;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee) throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(int id) throws SQLException;
    void startTranscation() throws SQLException;
    void commitTransaction() throws SQLException;
    void rollbackTransaction() throws SQLException;


    List<Employee> getEmployee() throws SQLException;
    Employee employeeById(int id) throws SQLException;

}
