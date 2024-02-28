package com.wallet.app.Service;

import com.wallet.app.DAO.AccountDAO;
import com.wallet.app.Model.Account;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AccountService {
    private AccountDAO accountDAO;
    public  AccountService (AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }
    public List<Account> allAccount() throws SQLException {
        return accountDAO.findAll();
    }
}
