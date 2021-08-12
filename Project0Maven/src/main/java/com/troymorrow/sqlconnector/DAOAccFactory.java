package com.troymorrow.sqlconnector;

import java.sql.SQLException;

public class DAOAccFactory {
    private static DAOAccount daoA;
    private DAOAccFactory(){}

    public static DAOAccount getDaoAccount() throws SQLException {
        if (daoA == null)
            daoA = new DAOAccImpl();
        return daoA;
    }
}
