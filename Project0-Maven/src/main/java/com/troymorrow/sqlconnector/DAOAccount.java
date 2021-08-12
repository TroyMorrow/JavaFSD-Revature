package com.troymorrow.sqlconnector;

import java.sql.SQLException;
import java.util.List;

public interface DAOAccount {
    void addAccount (Account account) throws SQLException;
    void updateAccount (Account account) throws SQLException;
    void updateAccountStatus(Account account) throws SQLException;
    void deleteAccount(Account account);
    List<Account> accountById (int id) throws SQLException;

    List<Account> accountByStatus() throws SQLException;
}
