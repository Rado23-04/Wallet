package com.wallet.app.Service;

import com.wallet.app.DAO.AccountTransactionDAO;
import com.wallet.app.Model.Account;
import com.wallet.app.Model.AccountTransaction;
import com.wallet.app.Model.Currency;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class AccountTransactionService {
    private AccountTransactionDAO accountTransactionDAO;
    public AccountTransactionService(AccountTransactionDAO accountTransactionDAO){
        this.accountTransactionDAO = accountTransactionDAO;
    }
    public List<AccountTransaction> allTransaction() throws SQLException {
        return accountTransactionDAO.findAll();
    }
    public void deleteAccountTransaction(int id) throws SQLException {
        accountTransactionDAO.delete(id);
    }
    public AccountTransaction insert(AccountTransaction toInsert){
        accountTransactionDAO.save(toInsert);
        return toInsert;
    }
}
