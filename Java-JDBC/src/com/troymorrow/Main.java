package com.troymorrow;

import java.sql.*;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("jdbc:mysql://localhost:3306/revature");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "RevPr0-21");

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from employee");
        while (resultSet.next()){
            System.out.println("ID: " + resultSet.getInt(1) + ", Name: " +
                    resultSet.getString(2) + ", Email: " + resultSet.getString(3));
        }

        conn.close();
    }
}
