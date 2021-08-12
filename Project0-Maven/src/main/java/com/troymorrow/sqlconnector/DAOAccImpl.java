package com.troymorrow.sqlconnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOAccImpl implements DAOAccount{
    private static Statement statment = null;
    Connection connection = null;
    public DAOAccImpl() {
        try {
            this.connection = Connector.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void addAccount(Account account) throws SQLException {
        String sql= "insert into accounts (cust_id, acc_type, balance) values (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, account.getCustId());
        ps.setString(2, account.getAccType());
        ps.setDouble(3, account.getBalance());
        int count = ps.executeUpdate();
        if (account.getBalance() >= 250)
            account.setAccStatus("Approved");
        else
            account.setAccStatus("Declined");

        if (count > 0 )
            System.out.println("New Account Added");
        else
            System.out.println("Incorrect Entry/Information");
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        String sql= "update accounts set balance = ? where acc_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDouble(1, account.getBalance());
        ps.setInt(2, account.getAccID());
        int count = ps.executeUpdate();
        if (count > 0 )
            System.out.println("Account Updated");
        else
            System.out.println("Incorrect Entry/Information");
    }

    @Override
    public void updateAccountStatus(Account account) throws SQLException {
        String sql= "update accounts set status = ? where acc_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, account.getAccStatus());
        ps.setInt(2, account.getAccID());
        int count = ps.executeUpdate();
        if (count > 0 )
            System.out.println("Account Updated");
        else
            System.out.println("Incorrect Entry/Information");
    }

    @Override
    public void deleteAccount(Account account) {

    }

    @Override
    public List<Account> accountById(int Id) throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String sql = "call sp_get_cust_acc(" +Id+ ")";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            int accId = resultSet.getInt(1);
            int custId = resultSet.getInt(2);
            String firstName = resultSet.getString(3);
            String lastName = resultSet.getString(4);
            String accType= resultSet.getString(5);
            double balance = resultSet.getDouble(6);
            String accStatus = resultSet.getString(7);

            Account account = new Account(accId, custId, firstName, lastName, accType, balance, accStatus );
            accounts.add(account);
        }
        return accounts;
    }

    @Override
    public List<Account> accountByStatus() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String sql = "call sp_get_cust_accStatus()";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            int accId = resultSet.getInt(1);
            int custId = resultSet.getInt(2);
            String firstName = resultSet.getString(3);
            String lastName = resultSet.getString(4);
            String accType= resultSet.getString(5);
            double balance = resultSet.getDouble(6);
            String accStatus = resultSet.getString(7);

            Account account = new Account (accId, custId, firstName, lastName, accType, balance, accStatus);
            accounts.add(account);
        }
        return accounts;
    }
}
