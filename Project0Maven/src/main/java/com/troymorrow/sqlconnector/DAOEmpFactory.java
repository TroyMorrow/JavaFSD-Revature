package com.troymorrow.sqlconnector;

public class DAOEmpFactory {
    private static DAOEmployee daoE;
    private DAOEmpFactory(){}

    public static DAOEmployee getDaoEmployee(){
        if (daoE == null)
            daoE = new DAOEmpImpl();
        return daoE;
    }
}
