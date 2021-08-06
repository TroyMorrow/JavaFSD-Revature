package com.troymorrow.sqlconnector;

import java.sql.*;
import java.util.ResourceBundle;

public class Connector {

    private static Connection connection = null;
    private Connector(){}

    public static Connection getConnection() throws SQLException {
        if (connection == null){
            ResourceBundle bundle = ResourceBundle.getBundle("com/troymorrow/sqlconnector/dbConfig");
            String url = bundle.getString("url");
            String username = bundle.getString("username");
            String password = bundle.getString("password");
            connection = DriverManager.getConnection(url,username,password);
        }
        return connection;
    }
}
