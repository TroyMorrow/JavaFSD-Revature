package com.troymorrow.sqlconnector;

public class DAOCustFactory {
    private static DAOCustomer dao;
    private DAOCustFactory(){}

    public static DAOCustomer getDaoCustomer(){
        if (dao == null)
            dao = new DAOCustImpl();
        return dao;
    }
}
