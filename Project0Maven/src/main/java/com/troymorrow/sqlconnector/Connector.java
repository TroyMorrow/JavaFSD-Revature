package com.troymorrow.sqlconnector;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Connector {

    private static Connection connection = null;
    private Connector(){}

    public static Connection getConnection() throws SQLException {
        if (connection == null){
//            ResourceBundle bundle = ResourceBundle.getBundle("com/troymorrow/sqlconnector/dbConfig");
            String url = "jdbc:mysql://localhost:3306/project0"; //bundle.getString("url");
            String username = "root"; //bundle.getString("username");
            String password = "RevPr0-21"; //bundle.getString("password");
            connection = DriverManager.getConnection(url,username,password);
        }
        return connection;
    }
}
