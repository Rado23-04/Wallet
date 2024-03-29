package com.wallet.app.Service;

import com.wallet.app.DAO.TransactionDAO;
import com.wallet.app.Model.Currency;
import com.wallet.app.Model.Transaction;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TransactionService {
    private TransactionDAO transactionDAO;
    public TransactionService (TransactionDAO transactionDAO){
        this.transactionDAO = transactionDAO;
    }
    public List<Transaction> allTransaction() throws SQLException {
        return transactionDAO.findAll();
    }
    public void deleteTransaction(int id) throws SQLException {
        transactionDAO.delete(id);
    }
    public Transaction insert(Transaction toInsert){
        transactionDAO.save(toInsert);
        return toInsert;
    }
}
